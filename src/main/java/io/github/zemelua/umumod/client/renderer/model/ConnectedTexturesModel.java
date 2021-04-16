package io.github.zemelua.umumod.client.renderer.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import io.github.zemelua.umumod.client.renderer.model.connection.IConnection;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.MissingTextureSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.TransformationMatrix;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraftforge.client.model.IModelConfiguration;
import net.minecraftforge.client.model.IModelLoader;
import net.minecraftforge.client.model.ModelTransformComposition;
import net.minecraftforge.client.model.PerspectiveMapWrapper;
import net.minecraftforge.client.model.data.*;
import net.minecraftforge.client.model.geometry.IModelGeometry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Function;

public class ConnectedTexturesModel implements IModelGeometry<ConnectedTexturesModel> {
	private final BlockModel baseModel;
	private final Map<String, IConnection> connections;

	public ConnectedTexturesModel(BlockModel baseModel, Map<String, IConnection> connections) {
		this.baseModel = baseModel;
		this.connections = connections;
	}

	@Override
	public IBakedModel bake(IModelConfiguration owner, ModelBakery bakery, Function<RenderMaterial, TextureAtlasSprite> spriteGetter, IModelTransform modelTransform, ItemOverrideList overrides, ResourceLocation modelLocation) {
		return new BakedModel(
			baseModel,
			baseModel.bakeModel(bakery, baseModel, spriteGetter, modelTransform, modelLocation, owner.isShadedInGui()),
			connections, PerspectiveMapWrapper.getTransforms(new ModelTransformComposition(owner.getCombinedTransform(), modelTransform)),
			modelTransform, modelLocation
		);
	}

	@Override
	public Collection<RenderMaterial> getTextures(IModelConfiguration owner, Function<ResourceLocation, IUnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors) {
		List<RenderMaterial> textures = new ArrayList<>();
		connections.values().forEach(i -> textures.addAll(i.getTextures()));
		textures.addAll(baseModel.getTextures(modelGetter, missingTextureErrors));
		return textures;
	}

	public static final class BakedModel implements IDynamicBakedModel {
		private final BlockModel baseModel;
		private final IBakedModel baseModelBaked;
		private final Map<String, IConnection> connections;
		private final ImmutableMap<ItemCameraTransforms.TransformType, TransformationMatrix> cameraTransforms;
		private final IModelTransform modelTransform;
		private final ResourceLocation modelLocation;

		private static final ModelProperty<ConnectionData> CONNECTION_DATA = new ModelProperty<>();

		private static final FaceBakery FACE_BAKERY = new FaceBakery();

		public BakedModel(BlockModel baseModel, IBakedModel baseModelBaked, Map<String, IConnection> connections, ImmutableMap<ItemCameraTransforms.TransformType, TransformationMatrix> cameraTransforms, IModelTransform modelTransform, ResourceLocation modelLocation) {
			this.baseModel = baseModel;
			this.baseModelBaked = baseModelBaked;
			this.connections = connections;
			this.cameraTransforms = cameraTransforms;
			this.modelTransform = modelTransform;
			this.modelLocation = modelLocation;
		}

		private IConnection resolveConnection(String nameIn) {
			if (nameIn.charAt(0) == '#') {
				nameIn = nameIn.substring(1);
			}

			List<String> list = Lists.newArrayList();

			while(true) {
				Either<RenderMaterial, String> either = this.findTexture(nameIn);
				Optional<String> optional = either.right();
				if (optional.isPresent()) {
					return connections.get(optional.get());
				}

				if (list.contains(nameIn)) {
					return null;
				}

				list.add(nameIn);
			}
		}

		private Either<RenderMaterial, String> findTexture(String nameIn) {
			for (BlockModel blockModel = baseModel; blockModel != null; blockModel =  blockModel.parent) {
				Either<RenderMaterial, String> either = blockModel.textures.get(nameIn);
				if (either != null) {
					return either;
				}
			}

			return Either.left(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, MissingTextureSprite.getLocation()));
		}

		private static BakedQuad bakeFace(BlockPart partIn, BlockPartFace partFaceIn, TextureAtlasSprite spriteIn, Direction directionIn, IModelTransform transformIn, ResourceLocation locationIn) {
			return FACE_BAKERY.bakeQuad(partIn.positionFrom, partIn.positionTo, partFaceIn, spriteIn, directionIn, transformIn, partIn.partRotation, partIn.shade, locationIn);
		}

		@Nonnull
		@Override
		public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData) {
			SimpleBakedModel.Builder builder = new SimpleBakedModel.Builder(
				baseModel, baseModelBaked.getOverrides(), baseModelBaked.isGui3d()).setTexture(baseModelBaked.getParticleTexture()
			);

			for(BlockPart blockpart : baseModel.getElements()) {
				for(Direction direction : blockpart.mapFaces.keySet()) {
					BlockPartFace blockpartface = blockpart.mapFaces.get(direction);

					TextureAtlasSprite sprite = baseModel.resolveTextureName(blockpartface.texture).getSprite();

					if (blockpartface.cullFace == null) {
						builder.addGeneralQuad(bakeFace(blockpart, blockpartface, sprite, direction, modelTransform, modelLocation));
					} else {
						if (extraData.hasProperty(CONNECTION_DATA)) {
							ConnectionData connectionData = extraData.getData(CONNECTION_DATA);
							sprite = resolveConnection(blockpartface.texture).makeTexture(connectionData.getWorld(), connectionData.getPos(), state, direction, sprite);
						}
						builder.addFaceQuad(
							Direction.rotateFace(modelTransform.getRotation().getMatrix(), blockpartface.cullFace),
							bakeFace(blockpart, blockpartface, sprite, direction, modelTransform, modelLocation)
						);
					}
				}
			}

			return builder.build().getQuads(state, side, rand);
		}

		@Override
		public IModelData getModelData(@Nonnull IBlockDisplayReader world, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull IModelData tileData) {
			if (tileData == EmptyModelData.INSTANCE) {
				tileData = new ModelDataMap.Builder().withProperty(CONNECTION_DATA).build();
			}
			tileData.setData(CONNECTION_DATA, new ConnectionData(world, pos));
			return tileData;
		}

		@Override
		public boolean isAmbientOcclusion() {
			return this.baseModelBaked.isAmbientOcclusion();
		}

		@Override
		public boolean isGui3d() {
			return this.baseModelBaked.isGui3d();
		}

		@Override
		public boolean isSideLit() {
			return this.baseModelBaked.isSideLit();
		}

		@Override
		public boolean isBuiltInRenderer() {
			return this.baseModelBaked.isBuiltInRenderer();
		}

		@Override
		public TextureAtlasSprite getParticleTexture() {
			return this.baseModelBaked.getParticleTexture();
		}

		@Override
		public ItemOverrideList getOverrides() {
			return this.baseModelBaked.getOverrides();
		}

		@Override
		public ItemCameraTransforms getItemCameraTransforms() {
			return baseModelBaked.getItemCameraTransforms();
		}
	}

	public static class Loader implements IModelLoader<ConnectedTexturesModel> {
		public static Loader INSTANCE = new Loader();

		@Override
		public void onResourceManagerReload(IResourceManager resourceManager) {}

		@Override
		public ConnectedTexturesModel read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
			modelContents.remove("loader");
			BlockModel baseModel = deserializationContext.deserialize(modelContents, BlockModel.class);

			Map<String, IConnection> connections = new HashMap<>();
			if (modelContents.has("connections")) {
				JsonObject connectionsObject = modelContents.get("connections").getAsJsonObject();

				for (Map.Entry<String, JsonElement> entry : connectionsObject.entrySet()) {
					connections.put(entry.getKey(), UMUModelLoaders.INSTANCE.fromJson(entry.getValue(), IConnection.class));
				}
			}

			return new ConnectedTexturesModel(baseModel, connections);
		}
	}
}

package io.github.zemelua.umumod.client.renderer.model.connection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.*;
import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.util.math.Vector2i;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.MissingTextureSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;
import java.lang.reflect.Type;
import java.util.*;

public class TileConnection implements IConnection {
	private final ImmutableList<Element> elements;

	public TileConnection(ImmutableList<Element> elements) {
		this.elements = elements;
	}

	@Override
	public TextureAtlasSprite makeTexture(IBlockReader world, BlockPos pos, BlockState state, Direction face, TextureAtlasSprite base) {
		TextureAtlasSprite sprite = base;
		for (Element element : elements) {
			Map<Vector2i, Boolean> canConnects = new HashMap<>();
			for (int u = 0; u < element.getWidth(); u++) {
				for (int v = 0; v < element.getHeight(); v++) {
					if (face.getAxis() != Direction.Axis.Y) {
						canConnects.put(new Vector2i( u,  v), canConnect(pos, pos.offset(face.rotateYCCW(),  u).up( v), world, face));
						canConnects.put(new Vector2i( u, -v), canConnect(pos, pos.offset(face.rotateYCCW(),  u).up(-v), world, face));
						canConnects.put(new Vector2i(-u,  v), canConnect(pos, pos.offset(face.rotateYCCW(), -u).up( v), world, face));
						canConnects.put(new Vector2i(-u, -v), canConnect(pos, pos.offset(face.rotateYCCW(), -u).up(-v), world, face));
					}
					Vector2i textureLocation = makeTileLocation(element.getWidth(), element.getHeight(), canConnects);

					if (textureLocation != null) {
						sprite = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, element.textures.get(textureLocation)).getSprite();
					}
				}
			}
		}

		return sprite;
	}

	@Nonnull
	@Override
	public List<RenderMaterial> getTextures() {
		List<RenderMaterial> textures = new ArrayList<>();
		for (Element element : elements) {
			for (ResourceLocation texture : element.getTextures().values()) {
				textures.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, texture));
			}
		}
		return textures;
	}

	@SuppressWarnings("RedundantIfStatement")
	private static boolean canConnect(BlockPos pos, BlockPos connectTo, IBlockReader world, Direction face) {
		BlockState state = world.getBlockState(pos);
		BlockState connectToState = world.getBlockState(connectTo);
		//boolean canConnect = Block.shouldSideBeRendered(world.getBlockState(connectTo), world, connectTo, face)
		//	&& (world.getBlockState(pos).getBlock() == world.getBlockState(connectTo).getBlock());
		if (state.getBlock() == connectToState.getBlock()) {
			/*
			if (world.getBlockState(pos).getBlock() instanceof ConnectionSwitchBlock) {
				if (state.get(BlockStateProperties.CONNECTION_SWITCH) == connectToState.get(BlockStateProperties.CONNECTION_SWITCH)) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
			 */
			return true;
		}
		return false;
	}

	private static Vector2i makeTileLocation(int width, int height, Map<Vector2i, Boolean> canConnects) {
		Vector2i location = Vector2i.ZERO;
		for (int ReferenceU = -(width - 1); ReferenceU < 1; ReferenceU++) {
			for (int ReferenceV = -(height - 1); ReferenceV < 1; ReferenceV++) {
				// ここでu, v はタイルの左下
				List<Boolean> tryTile = new ArrayList<>();
				for (int indexU = 0; indexU < width; indexU++) {
					for (int indexV = 0; indexV < height; indexV++) {
						Vector2i canConnect = new Vector2i(ReferenceU + indexU, ReferenceV + indexV);
						tryTile.add(canConnects.get(canConnect));
						if (canConnect.equals(Vector2i.ZERO)) {
							location = new Vector2i(indexU, indexV);
						}
					}
				}

				if (!tryTile.contains(false) && !tryTile.contains(null)) {
					return location;
				}
			}
		}
		return null;
	}

	public static class Element {
		private final int width;
		private final int height;
		private final ImmutableMap<Vector2i, ResourceLocation> textures;

		public Element(int width, int height, ImmutableList<ResourceLocation> textures) {
			this.width = width;
			this.height = height;
			ImmutableMap.Builder<Vector2i, ResourceLocation> builder = ImmutableMap.builder();
			int index = 0;
			for (int u = 0; u < width; u++) {
				for (int v = 0; v < height; v++) {
					Optional<ResourceLocation> texture;
					try {
						texture = Optional.ofNullable(textures.get(index));
					} catch (IndexOutOfBoundsException exception) {
						UMUMod.LOGGER.warn("Not enough textures to make for Tile connection!");
						texture = Optional.of(MissingTextureSprite.getLocation());
					}
					builder.put(new Vector2i(u, v), texture.orElseGet(MissingTextureSprite::getLocation));
					index++;
				}
			}
			this.textures = builder.build();
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		public ImmutableMap<Vector2i, ResourceLocation> getTextures() {
			return textures;
		}
	}

	public static class Deserializer implements JsonDeserializer<TileConnection> {
		@SuppressWarnings("ConstantConditions")
		@Override
		public TileConnection deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
			JsonObject jsonObject = jsonElement.getAsJsonObject();

			ImmutableList.Builder<Element> tiles = ImmutableList.builder();
			if (jsonObject.has("elements")) {
				List<JsonElement> tileElements = new ArrayList<>();
				try {
					tileElements.add(jsonObject.get("elements").getAsJsonObject());
				} catch (IllegalStateException exception) {
					for (JsonElement element : jsonObject.get("elements").getAsJsonArray()) {
						tileElements.add(element);
					}
				}

				for (JsonElement tileElement : tileElements) {
					JsonObject tileObject = tileElement.getAsJsonObject();
					int width = 0;
					int height = 0;
					ImmutableList.Builder<ResourceLocation> textures = ImmutableList.builder();
					if (tileObject.has("size")) {
						JsonArray sizeArray = tileObject.get("size").getAsJsonArray();
						width = sizeArray.get(0).getAsInt();
						height = sizeArray.get(1).getAsInt();
					}
					if (tileObject.has("textures")) {
						for (JsonElement textureElement : tileObject.get("textures").getAsJsonArray()) {
							textures.add(ResourceLocation.tryCreate(textureElement.getAsString()));
						}
					}
					tiles.add(new Element(width, height, textures.build()));
				}
			}

			return new TileConnection(tiles.build());
		}
	}
}

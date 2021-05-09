package io.github.zemelua.umumod.client.renderer.model.connection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.*;
import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.util.math.Vector2i;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.MissingTextureSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.state.Property;
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
			boolean connectback = element.canConnectback();
			String[] variants = element.getVariants();
			for (int u = 0; u < element.getWidth(); u++) {
				for (int v = 0; v < element.getHeight(); v++) {
					if (face.getAxis() != Direction.Axis.Y) {
						canConnects.put(new Vector2i( u,  v), canConnect(new Vector2i( u,  v), pos, pos.offset(face.rotateYCCW(),  u).up( v), world, face, connectback, variants));
						canConnects.put(new Vector2i( u, -v), canConnect(new Vector2i( u, -v), pos, pos.offset(face.rotateYCCW(),  u).up(-v), world, face, connectback, variants));
						canConnects.put(new Vector2i(-u,  v), canConnect(new Vector2i(-u,  v), pos, pos.offset(face.rotateYCCW(), -u).up( v), world, face, connectback, variants));
						canConnects.put(new Vector2i(-u, -v), canConnect(new Vector2i(-u, -v), pos, pos.offset(face.rotateYCCW(), -u).up(-v), world, face, connectback, variants));
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

	private static boolean canConnect(Vector2i location, BlockPos pos, BlockPos connectTo, IBlockReader world, Direction face, boolean connectback, String[] variants) {
		BlockState state = world.getBlockState(pos);
		BlockState connectToState = world.getBlockState(connectTo);

		boolean matchesBlock = state.matchesBlock(connectToState.getBlock());
		boolean isRendered = true;
		if (!connectback) {
			isRendered = Block.shouldSideBeRendered(connectToState, world, connectTo, face);
		}
		boolean matchesProperties = true;
		LABEL:
		for (String propertyName : variants) {
			for (Property<?> property : state.getProperties()) {
				if (property.getName().equalsIgnoreCase(propertyName) && connectToState.hasProperty(property)) {
					matchesProperties = state.get(property).equals(connectToState.get(property));
					if (!matchesProperties) break LABEL;
				}
			}
		}

		return matchesBlock && isRendered && matchesProperties;
	}

	private static Vector2i makeTileLocation(int width, int height, Map<Vector2i, Boolean> canConnects) {
		Vector2i location = Vector2i.ZERO;
		for (int ReferenceU = -(width - 1); ReferenceU < 1; ReferenceU++) {
			for (int ReferenceV = -(height - 1); ReferenceV < 1; ReferenceV++) {
				// ここでu, v はタイルの左下
				List<Boolean> tryTile = new ArrayList<>();
				for (int indexU = 0; indexU < width; indexU++) {
					for (int indexV = 0; indexV < height; indexV++) {
						Vector2i canMakeTileLocation = new Vector2i(ReferenceU + indexU, ReferenceV + indexV);
						tryTile.add(canConnects.get(canMakeTileLocation));
						if (canMakeTileLocation.equals(Vector2i.ZERO)) location = new Vector2i(indexU, indexV);
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
		private final boolean connectback;
		private final String[] variants;
		private final ImmutableMap<Vector2i, ResourceLocation> textures;

		public Element(int width, int height, boolean connectback, String[] variants, ImmutableList<ResourceLocation> textures) {
			this.width = width;
			this.height = height;
			this.connectback = connectback;
			this.variants = variants;
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

		public boolean canConnectback() {
			return connectback;
		}

		public String[] getVariants() {
			return variants;
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
					boolean connectback = false;
					if (tileObject.has("connectback")) {
						connectback = tileObject.get("connectback").getAsBoolean();
					}
					List<String> variants = new ArrayList<>();
					if (tileObject.has("variants")) {
						for (JsonElement variantElement : tileObject.get("variants").getAsJsonArray()) {
							variants.add(variantElement.getAsString());
						}
					}
					if (tileObject.has("textures")) {
						for (JsonElement textureElement : tileObject.get("textures").getAsJsonArray()) {
							textures.add(ResourceLocation.tryCreate(textureElement.getAsString()));
						}
					}
					tiles.add(new Element(width, height, connectback, variants.toArray(new String[0]), textures.build()));
				}
			}

			return new TileConnection(tiles.build());
		}
	}
}

package io.github.zemelua.umumod.client.renderer.model.connection;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.*;
import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.util.UMUUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.MissingTextureSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FlexibleConnection implements IConnection {
	private final Element[] elements;

	public FlexibleConnection(Element[] elements) {
		this.elements = elements;
	}

	@Override
	public TextureAtlasSprite makeTexture(IBlockReader world, BlockPos pos, BlockState state, Direction face, TextureAtlasSprite base) {
		for (Element merge : elements) {
			boolean[] canConnects = new boolean[8];
			for (int i = 0; i < canConnects.length; i++) {
				canConnects[i] = canConnect(ForgeRegistries.BLOCKS.getValue(merge.into), UMUUtils.getAroundFaces(world, pos, face)[i], face);
			}
			return merge.makeTexture(canConnects, base);
		}
		return base;
	}

	@Nonnull
	@Override
	public List<RenderMaterial> getTextures() {
		List<RenderMaterial> textures = new ArrayList<>();
		for (Element merge : elements) {
			for (ResourceLocation texture : merge.textures.values()) {
				textures.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, texture));
			}
		}
		return textures;
	}

	private static boolean canConnect(Block into, BlockState connectTo, Direction face) {
		return into == connectTo.getBlock();
	}

	public static class Element {
		private final ResourceLocation into;
		private final ImmutableMap<FlexibleContext, ResourceLocation> textures;

		public Element(ResourceLocation into, ImmutableList<ResourceLocation> textures, FlexibleContext[] shape) {
			this.into = into;
			ImmutableMap.Builder<FlexibleContext, ResourceLocation> builder = ImmutableMap.builder();
			for (int i = 0; i < shape.length; i++) {
				Optional<ResourceLocation> texture;
				try {
					texture = Optional.ofNullable((textures.get(i)));
				} catch (IndexOutOfBoundsException exception) {
					UMUMod.LOGGER.warn("Not enough textures to make for Merge connection!");
					texture = Optional.of(MissingTextureSprite.getLocation());
				}
				builder.put(shape[i], texture.orElseGet(MissingTextureSprite::getLocation));
			}
			this.textures = builder.build();
		}

		@Nullable
		public TextureAtlasSprite makeTexture(boolean[] canConnects, TextureAtlasSprite base) {
			for (Map.Entry<FlexibleContext, ResourceLocation> entry : textures.entrySet()) {
				if (entry.getKey().isSameContext(canConnects)) {
					return new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, entry.getValue()).getSprite();
				}
			}
			return base;
		}
	}

	public static class Deserializer implements JsonDeserializer<FlexibleConnection> {
		public static final ImmutableMap<String, FlexibleContext[]> SHAPES = ImmutableMap.<String, FlexibleContext[]>builder()
			.put("vertical", FlexibleContext.VERTICAL)
			.put("horizontal", FlexibleContext.HORIZONTAL)
			.put("cross", FlexibleContext.CROSS)
			.put("full", FlexibleContext.FULL)
			.build();

		@Override
		public FlexibleConnection deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
			JsonObject jsonObject = jsonElement.getAsJsonObject();

			List<Element> merges = new ArrayList<>();
			if (jsonObject.has("merges")) {
				for (JsonElement mergeElement : jsonObject.get("merges").getAsJsonArray()) {
					JsonObject mergeObject = mergeElement.getAsJsonObject();

					ResourceLocation into = null;
					ImmutableList.Builder<ResourceLocation> textures = ImmutableList.builder();
					FlexibleContext[] shape = FlexibleContext.FULL;

					if (mergeObject.has("into")) {
						into = ResourceLocation.tryCreate(mergeObject.get("into").getAsString());
					}
					if (mergeObject.has("textures")) {
						for (JsonElement textureElement : mergeObject.get("textures").getAsJsonArray()) {
							textures.add(ResourceLocation.tryCreate(textureElement.getAsString()));
						}
					}
					if (mergeObject.has("shape")) {
						shape = SHAPES.get(mergeObject.get("shape").getAsString());
					}

					merges.add(new Element(into, textures.build(), shape));
				}
			}

			return new FlexibleConnection(merges.toArray(new Element[merges.size()]));
		}
	}
}
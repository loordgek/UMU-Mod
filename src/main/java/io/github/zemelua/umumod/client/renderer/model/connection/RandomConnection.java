package io.github.zemelua.umumod.client.renderer.model.connection;

import com.google.common.collect.ImmutableList;
import com.google.gson.*;
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
import java.util.ArrayList;
import java.util.List;

public class RandomConnection implements IConnection {
	private final ImmutableList<Element> elements;

	public RandomConnection(ImmutableList<Element> elements) {
		this.elements = elements;
	}

	@Override
	public TextureAtlasSprite makeTexture(IBlockReader world, BlockPos pos, BlockState state, Direction face, TextureAtlasSprite base) {
		int sum = elements.stream().mapToInt(r -> r.frequency).sum();
		int rand = new java.util.Random(pos.toLong() * face.getIndex()).nextInt(sum);
		int indexMax = 0;
		int indexMin = 0;
		for (Element element : elements) {
			indexMax = indexMax + element.frequency;
			if (rand < indexMax && rand >= indexMin) {
				return new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, element.texture).getSprite();
			}
			indexMin = indexMax;
		}
		return base;
	}

	@Nonnull
	@Override
	public List<RenderMaterial> getTextures() {
		List<RenderMaterial> textures = new ArrayList<>();
		for (Element element : elements) {
			textures.add(new RenderMaterial(AtlasTexture.LOCATION_BLOCKS_TEXTURE, element.texture));
		}
		return textures;
	}

	public static class Element {
		private final int frequency;
		private final ResourceLocation texture;

		public Element(int frequency, ResourceLocation texture) {
			this.frequency = frequency;
			this.texture = texture;
		}
	}

	public static class Deserializer implements JsonDeserializer<RandomConnection> {
		@Override
		public RandomConnection deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
			JsonObject jsonObject = jsonElement.getAsJsonObject();

			ImmutableList.Builder<Element> randoms = ImmutableList.builder();
			if (jsonObject.has("random")) {
				ImmutableList.Builder<JsonElement> randomElements = ImmutableList.builder();
				try {
					randomElements.add(jsonObject.get("random").getAsJsonObject());
				} catch (IllegalStateException exception) {
					randomElements.addAll(jsonObject.get("random").getAsJsonArray());
				}

				for (JsonElement randomElement : randomElements.build()) {
					JsonObject randomObject = randomElement.getAsJsonObject();
					int frequency = 0;
					ResourceLocation texture = MissingTextureSprite.getLocation();
					if (randomObject.has("weight")) {
						frequency = randomObject.get("weight").getAsInt();
					}
					if (randomObject.has("texture")) {
						texture = ResourceLocation.tryCreate(randomObject.get("texture").getAsString());
					}
					randoms.add(new Element(frequency, texture));
				}
			}
			return new RandomConnection(randoms.build());
		}
	}
}

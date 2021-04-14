package io.github.zemelua.umumod.client.renderer.model.connection;

import com.google.common.collect.ImmutableMap;
import com.google.gson.*;
import io.github.zemelua.umumod.client.renderer.model.UMUModelLoaders;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.lang.reflect.Type;
import java.util.List;

public interface IConnection {
	/**
	 * Makes a sprite according to connection.
	 *
	 * @param world the reader to read block from pos
	 * @param pos   the pos that the model is in
	 * @param state the block which the sprite is applied. This is the same as the BlockState returned by {@code world.getBlockState(pos)}
	 * @param base
	 * @return {@code Optional} that holds a sprite if the connection goes well, {@code Optional.empty()} otherwise
	 */
	public TextureAtlasSprite makeTexture(IBlockReader world, BlockPos pos, BlockState state, Direction face, TextureAtlasSprite base);

	/**
	 * Get all sprites that may be used.
	 *
	 * @return {@code List} of sprites that may be used in connection.
	 */
	@Nonnull
	public List<RenderMaterial> getTextures();

	@OnlyIn(Dist.CLIENT)
	public static class Deserializer implements JsonDeserializer<IConnection> {
		public static final ImmutableMap<String, Class<? extends IConnection>> CONNECTIONS = ImmutableMap.<String, Class<? extends IConnection>>builder()
			.put("flexible", FlexibleConnection.class)
			.build();

		@Override
		public IConnection deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
			JsonObject jsonObject = jsonElement.getAsJsonObject();

			if (jsonObject.has("type")) {
				return UMUModelLoaders.INSTANCE.fromJson(jsonObject, CONNECTIONS.get(jsonObject.get("type").getAsString()));
			}

			return null;
		}
	}
}

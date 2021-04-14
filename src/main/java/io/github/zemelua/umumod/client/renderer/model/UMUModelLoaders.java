package io.github.zemelua.umumod.client.renderer.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.client.renderer.model.connection.IConnection;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class UMUModelLoaders {
	public static final Gson INSTANCE = new GsonBuilder()
		.registerTypeAdapter(IConnection.class, new IConnection.Deserializer())
		.create();

	@SubscribeEvent
	public static void registerModelLoader(final ModelRegistryEvent event) {
		ModelLoaderRegistry.registerLoader(new ResourceLocation(UMUMod.MODID, "connected-textures"), ConnectedTexturesModel.Loader.INSTANCE);
	}
}
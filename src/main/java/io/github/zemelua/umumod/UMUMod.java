package io.github.zemelua.umumod;

import io.github.zemelua.umumod.block.PlanterBlock;
import io.github.zemelua.umumod.block.UMUBlocks;
import io.github.zemelua.umumod.capability.UMUCapabilities;
import io.github.zemelua.umumod.client.renderer.model.UMUModelLoaders;
import io.github.zemelua.umumod.client.gui.screen.inventory.BelongingsInventoryScreen;
import io.github.zemelua.umumod.inventory.container.UMUContainers;
import io.github.zemelua.umumod.item.BackpackItem;
import io.github.zemelua.umumod.item.UMUItems;
import io.github.zemelua.umumod.network.UMUNetwork;
import io.github.zemelua.umumod.tileentity.UMUTileEntities;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UMUMod.MOD_ID)
public class UMUMod {
	public static final String MOD_ID = "umu";

	// Directly reference a log4j logger.
	public static final Logger LOGGER = LogManager.getLogger();

	public UMUMod() {
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		// Register the enqueueIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		// Register the processIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		// Register the doClientStuff method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

		UMUBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		UMUItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		UMUTileEntities.TILE_ENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
		UMUContainers.CONTAINER.register(FMLJavaModLoadingContext.get().getModEventBus());

		FMLJavaModLoadingContext.get().getModEventBus().register(UMUBlocks.class);
		FMLJavaModLoadingContext.get().getModEventBus().register(UMUModelLoaders.class);
		MinecraftForge.EVENT_BUS.register(new PlanterBlock(AbstractBlock.Properties.create(Material.ROCK)));
		MinecraftForge.EVENT_BUS.register(BackpackItem.class);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		// some preinit code
		LOGGER.info("HELLO FROM PREINIT");
		LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

		UMUNetwork.packetRegister();
		UMUCapabilities.register();
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		// do something that can only be done on the client
		LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);

		RenderTypeLookup.setRenderLayer(UMUBlocks.SAKURA_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UMUBlocks.FLOWER_BASKET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UMUBlocks.RED_FLOWER_BASKET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UMUBlocks.YELLOW_FLOWER_BASKET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UMUBlocks.WHITE_FLOWER_BASKET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UMUBlocks.BLUE_FLOWER_BASKET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UMUBlocks.COLORFUL_FLOWER_BASKET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UMUBlocks.BUSH_FLOWER_BASKET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UMUBlocks.SUSPICIOUS_FLOWER_BASKET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(UMUBlocks.NETHER_FLOWER_BASKET.get(), RenderType.getCutout());

		ScreenManager.registerFactory(UMUContainers.BELONGING_INVENTORY.get(), BelongingsInventoryScreen::new);
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {
		// some example code to dispatch IMC to another mod
		InterModComms.sendTo("UMUMod", "helloworld", () -> {
			LOGGER.info("Hello world from the MDK");
			return "Hello world";
		});
	}

	private void processIMC(final InterModProcessEvent event) {
		// some example code to receive and process InterModComms from other mods
		LOGGER.info("Got IMC {}", event.getIMCStream().
			map(m -> m.getMessageSupplier().get()).
			collect(Collectors.toList()));
	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		// do something when the server starts
		LOGGER.info("HELLO from server starting");
	}

/*
	// You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
	// Event bus for receiving Registry Events)

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
			// register a new block here
			blockRegistryEvent.getRegistry().register(new Block(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)).setRegistryName(new ResourceLocation("umumod", "white_planks")));
			LOGGER.info("HELLO from Register Block");
		}
	}
*/
}

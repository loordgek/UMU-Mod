package io.github.zemelua.umumod.util;

// This class is not currently in use.

/*
import io.github.zemelua.umumod.UMUMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = "umumod", bus = Mod.EventBusSubscriber.Bus.MOD)
public class UMURegistry<V extends IForgeRegistryEntry<V>> {
	public Map<ResourceLocation, V> objects = new HashMap<>();
	private IForgeRegistry<V> type;

	public static final UMURegistry<Block> BLOCKS = new UMURegistry<>(ForgeRegistries.BLOCKS);
	public static UMURegistry<Item> ITEMS = new UMURegistry<>(ForgeRegistries.ITEMS);

	private UMURegistry(IForgeRegistry<V> type) {
		this.type = type;
	}

	public static <V extends IForgeRegistryEntry<V>> V register(UMURegistry<V> registry, String key, V value) {
		registry.objects.put(new ResourceLocation("umumod", key), value);
		return value;
	}

	@SubscribeEvent
	public void onBlocksRegistry(final RegistryEvent.Register<?> event) {
		// register a new block here
		if (event.getGenericType() == type.getRegistrySuperType()) {
			UMUMod.LOGGER.debug(this.objects + "reggggg");
			for (V value : this.objects.values()) {
				UMUMod.LOGGER.debug(value.getRegistryName());
				((IForgeRegistry<V>)event.getRegistry()).register(value);
			}
		}
	}
}
 */

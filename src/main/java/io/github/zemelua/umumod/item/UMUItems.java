package io.github.zemelua.umumod.item;

import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.block.UMUBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UMUItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UMUMod.MODID);

	public static final RegistryObject<Item> OAK_VERTICAL_SLAB = ITEMS.register("oak_vertical_slab", () -> new BlockItem(UMUBlocks.OAK_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SPRUCE_VERTICAL_SLAB = ITEMS.register("spruce_vertical_slab", () -> new BlockItem(UMUBlocks.SPRUCE_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BIRCH_VERTICAL_SLAB = ITEMS.register("birch_vertical_slab", () -> new BlockItem(UMUBlocks.BIRCH_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> JUNGLE_VERTICAL_SLAB = ITEMS.register("jungle_vertical_slab", () -> new BlockItem(UMUBlocks.JUNGLE_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ACACIA_VERTICAL_SLAB = ITEMS.register("acacia_vertical_slab", () -> new BlockItem(UMUBlocks.ACACIA_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DARK_OAK_VERTICAL_SLAB = ITEMS.register("dark_oak_vertical_slab", () -> new BlockItem(UMUBlocks.DARK_OAK_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));

	public static final RegistryObject<Item> WOODEN_BOX = ITEMS.register("wooden_box", () -> new BlockItem(UMUBlocks.WOODEN_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> QUARTZ_COLUMN = ITEMS.register("quartz_column", () -> new BlockItem(UMUBlocks.QUARTZ_COLUMN.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

	// public static final RegistryObject<Item> BUMPKIN = ITEMS.register("bumpkin", () -> new BlockItem(UMUBlocks.BUMPKIN.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
}

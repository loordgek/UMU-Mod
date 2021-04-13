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

	public static final RegistryObject<Item> WHITE_PLANKS = ITEMS.register("white_planks", () -> new BlockItem(UMUBlocks.WHITE_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ORANGE_PLANKS = ITEMS.register("orange_planks", () -> new BlockItem(UMUBlocks.ORANGE_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> MAGENTA_PLANKS = ITEMS.register("magenta_planks", () -> new BlockItem(UMUBlocks.MAGENTA_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_BLUE_PLANKS = ITEMS.register("light_blue_planks", () -> new BlockItem(UMUBlocks.LIGHT_BLUE_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> YELLOW_PLANKS = ITEMS.register("yellow_planks", () -> new BlockItem(UMUBlocks.YELLOW_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIME_PLANKS = ITEMS.register("lime_planks", () -> new BlockItem(UMUBlocks.LIME_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PINK_PLANKS = ITEMS.register("pink_planks", () -> new BlockItem(UMUBlocks.PINK_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GRAY_PLANKS = ITEMS.register("gray_planks", () -> new BlockItem(UMUBlocks.GRAY_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_GRAY_PLANKS = ITEMS.register("light_gray_planks", () -> new BlockItem(UMUBlocks.LIGHT_GRAY_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CYAN_PLANKS = ITEMS.register("cyan_planks", () -> new BlockItem(UMUBlocks.CYAN_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PURPLE_PLANKS = ITEMS.register("purple_planks", () -> new BlockItem(UMUBlocks.PURPLE_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLUE_PLANKS = ITEMS.register("blue_planks", () -> new BlockItem(UMUBlocks.BLUE_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BROWN_PLANKS = ITEMS.register("brown_planks", () -> new BlockItem(UMUBlocks.BROWN_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GREEN_PLANKS = ITEMS.register("green_planks", () -> new BlockItem(UMUBlocks.GREEN_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RED_PLANKS = ITEMS.register("red_planks", () -> new BlockItem(UMUBlocks.RED_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLACK_PLANKS = ITEMS.register("black_planks", () -> new BlockItem(UMUBlocks.BLACK_PLANKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> WOODEN_BOX = ITEMS.register("wooden_box", () -> new BlockItem(UMUBlocks.WOODEN_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> QUARTZ_COLUMN = ITEMS.register("quartz_column", () -> new BlockItem(UMUBlocks.QUARTZ_COLUMN.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
}

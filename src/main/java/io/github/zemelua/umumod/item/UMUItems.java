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

	public static final RegistryObject<Item> WHITE_PLANKS = ITEMS.register("white_planks", () -> new BlockItem(UMUBlocks.WHITE_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ORANGE_PLANKS = ITEMS.register("orange_planks", () -> new BlockItem(UMUBlocks.ORANGE_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> MAGENTA_PLANKS = ITEMS.register("magenta_planks", () -> new BlockItem(UMUBlocks.MAGENTA_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_BLUE_PLANKS = ITEMS.register("light_blue_planks", () -> new BlockItem(UMUBlocks.LIGHT_BLUE_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> YELLOW_PLANKS = ITEMS.register("yellow_planks", () -> new BlockItem(UMUBlocks.YELLOW_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIME_PLANKS = ITEMS.register("lime_planks", () -> new BlockItem(UMUBlocks.LIME_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PINK_PLANKS = ITEMS.register("pink_planks", () -> new BlockItem(UMUBlocks.PINK_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GRAY_PLANKS = ITEMS.register("gray_planks", () -> new BlockItem(UMUBlocks.GRAY_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_GRAY_PLANKS = ITEMS.register("light_gray_planks", () -> new BlockItem(UMUBlocks.LIGHT_GRAY_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CYAN_PLANKS = ITEMS.register("cyan_planks", () -> new BlockItem(UMUBlocks.CYAN_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PURPLE_PLANKS = ITEMS.register("purple_planks", () -> new BlockItem(UMUBlocks.PURPLE_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLUE_PLANKS = ITEMS.register("blue_planks", () -> new BlockItem(UMUBlocks.BLUE_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BROWN_PLANKS = ITEMS.register("brown_planks", () -> new BlockItem(UMUBlocks.BROWN_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GREEN_PLANKS = ITEMS.register("green_planks", () -> new BlockItem(UMUBlocks.GREEN_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RED_PLANKS = ITEMS.register("red_planks", () -> new BlockItem(UMUBlocks.RED_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLACK_PLANKS = ITEMS.register("black_planks", () -> new BlockItem(UMUBlocks.BLACK_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));

	public static final RegistryObject<Item> OAK_VERTICAL_SLAB = ITEMS.register("oak_vertical_slab", () -> new BlockItem(UMUBlocks.OAK_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SPRUCE_VERTICAL_SLAB = ITEMS.register("spruce_vertical_slab", () -> new BlockItem(UMUBlocks.SPRUCE_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BIRCH_VERTICAL_SLAB = ITEMS.register("birch_vertical_slab", () -> new BlockItem(UMUBlocks.BIRCH_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> JUNGLE_VERTICAL_SLAB = ITEMS.register("jungle_vertical_slab", () -> new BlockItem(UMUBlocks.JUNGLE_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ACACIA_VERTICAL_SLAB = ITEMS.register("acacia_vertical_slab", () -> new BlockItem(UMUBlocks.ACACIA_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DARK_OAK_VERTICAL_SLAB = ITEMS.register("dark_oak_vertical_slab", () -> new BlockItem(UMUBlocks.DARK_OAK_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));

	public static final RegistryObject<Item> WHITE_WOODEN_DOOR = ITEMS.register("white_wooden_door", () -> new BlockItem(UMUBlocks.WHITE_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> ORANGE_WOODEN_DOOR = ITEMS.register("orange_wooden_door", () -> new BlockItem(UMUBlocks.ORANGE_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> MAGENTA_WOODEN_DOOR = ITEMS.register("magenta_wooden_door", () -> new BlockItem(UMUBlocks.MAGENTA_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> LIGHT_BLUE_WOODEN_DOOR = ITEMS.register("light_blue_wooden_door", () -> new BlockItem(UMUBlocks.LIGHT_BLUE_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> YELLOW_WOODEN_DOOR = ITEMS.register("yellow_wooden_door", () -> new BlockItem(UMUBlocks.YELLOW_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> LIME_WOODEN_DOOR = ITEMS.register("lime_wooden_door", () -> new BlockItem(UMUBlocks.LIME_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> PINK_WOODEN_DOOR = ITEMS.register("pink_wooden_door", () -> new BlockItem(UMUBlocks.PINK_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> GRAY_WOODEN_DOOR = ITEMS.register("gray_wooden_door", () -> new BlockItem(UMUBlocks.GRAY_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> LIGHT_GRAY_WOODEN_DOOR = ITEMS.register("light_gray_wooden_door", () -> new BlockItem(UMUBlocks.LIGHT_GRAY_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> CYAN_WOODEN_DOOR = ITEMS.register("cyan_wooden_door", () -> new BlockItem(UMUBlocks.CYAN_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> PURPLE_WOODEN_DOOR = ITEMS.register("purple_wooden_door", () -> new BlockItem(UMUBlocks.PURPLE_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> BLUE_WOODEN_DOOR = ITEMS.register("blue_wooden_door", () -> new BlockItem(UMUBlocks.BLUE_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> BROWN_WOODEN_DOOR = ITEMS.register("brown_wooden_door", () -> new BlockItem(UMUBlocks.BROWN_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> GREEN_WOODEN_DOOR = ITEMS.register("green_wooden_door", () -> new BlockItem(UMUBlocks.GREEN_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> RED_WOODEN_DOOR = ITEMS.register("red_wooden_door", () -> new BlockItem(UMUBlocks.RED_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> BLACK_WOODEN_DOOR = ITEMS.register("black_wooden_door", () -> new BlockItem(UMUBlocks.BLACK_WOODEN_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));

	public static final RegistryObject<Item> WOODEN_BOX = ITEMS.register("wooden_box", () -> new BlockItem(UMUBlocks.WOODEN_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> QUARTZ_COLUMN = ITEMS.register("quartz_column", () -> new BlockItem(UMUBlocks.QUARTZ_COLUMN.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

	// public static final RegistryObject<Item> BUMPKIN = ITEMS.register("bumpkin", () -> new BlockItem(UMUBlocks.BUMPKIN.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
}

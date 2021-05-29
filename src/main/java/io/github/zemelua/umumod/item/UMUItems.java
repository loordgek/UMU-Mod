package io.github.zemelua.umumod.item;

import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.block.UMUBlocks;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class UMUItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UMUMod.MODID);

	public static final RegistryObject<Item> SAKURA_LOG = ITEMS.register("sakura_log", () -> new BlockItem(UMUBlocks.SAKURA_LOG.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ASH_LOG = ITEMS.register("ash_log", () -> new BlockItem(UMUBlocks.ASH_LOG.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SAKURA_WOOD = ITEMS.register("sakura_wood", () -> new BlockItem(UMUBlocks.SAKURA_WOOD.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ASH_WOOD = ITEMS.register("ash_wood", () -> new BlockItem(UMUBlocks.ASH_WOOD.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STRIPPED_SAKURA_LOG = ITEMS.register("stripped_sakura_log", () -> new BlockItem(UMUBlocks.STRIPPED_SAKURA_LOG.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STRIPPED_ASH_LOG = ITEMS.register("stripped_ash_log", () -> new BlockItem(UMUBlocks.STRIPPED_ASH_LOG.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STRIPPED_SAKURA_WOOD = ITEMS.register("stripped_sakura_wood", () -> new BlockItem(UMUBlocks.STRIPPED_SAKURA_WOOD.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STRIPPED_ASH_WOOD = ITEMS.register("stripped_ash_wood", () -> new BlockItem(UMUBlocks.STRIPPED_ASH_WOOD.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SAKURA_SAPLING = ITEMS.register("sakura_sapling", () -> new BlockItem(UMUBlocks.SAKURA_SAPLING.get(), new Item.Properties().group(UMUItemGroups.DECORATIONS)));
	public static final RegistryObject<Item> ASH_SAPLING = ITEMS.register("ash_sapling", () -> new BlockItem(UMUBlocks.ASH_SAPLING.get(), new Item.Properties().group(UMUItemGroups.DECORATIONS)));
	public static final RegistryObject<Item> SAKURA_LEAVES = ITEMS.register("sakura_leaves", () -> new BlockItem(UMUBlocks.SAKURA_LEAVES.get(), new Item.Properties().group(UMUItemGroups.DECORATIONS)));
	public static final RegistryObject<Item> ASH_LEAVES = ITEMS.register("ash_leaves", () -> new BlockItem(UMUBlocks.ASH_LEAVES.get(), new Item.Properties().group(UMUItemGroups.DECORATIONS)));
	public static final RegistryObject<Item> SAKURA_PLANKS = ITEMS.register("sakura_planks", () -> new BlockItem(UMUBlocks.SAKURA_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ASH_PLANKS = ITEMS.register("ash_planks", () -> new BlockItem(UMUBlocks.ASH_PLANKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SAKURA_SLAB = ITEMS.register("sakura_slab", () -> new BlockItem(UMUBlocks.SAKURA_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ASH_SLAB = ITEMS.register("ash_slab", () -> new BlockItem(UMUBlocks.ASH_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SAKURA_STAIRS = ITEMS.register("sakura_stairs", () -> new BlockItem(UMUBlocks.SAKURA_STAIRS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ASH_STAIRS = ITEMS.register("ash_stairs", () -> new BlockItem(UMUBlocks.ASH_STAIRS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SAKURA_FENCE = ITEMS.register("sakura_fence", () -> new BlockItem(UMUBlocks.SAKURA_FENCE.get(), new Item.Properties().group(UMUItemGroups.DECORATIONS)));
	public static final RegistryObject<Item> ASH_FENCE = ITEMS.register("ash_fence", () -> new BlockItem(UMUBlocks.ASH_FENCE.get(), new Item.Properties().group(UMUItemGroups.DECORATIONS)));
	public static final RegistryObject<Item> SAKURA_FENCE_GATE = ITEMS.register("sakura_fence_gate", () -> new BlockItem(UMUBlocks.SAKURA_FENCE_GATE.get(), new Item.Properties().group(UMUItemGroups.DECORATIONS)));
	public static final RegistryObject<Item> ASH_FENCE_GATE = ITEMS.register("ash_fence_gate", () -> new BlockItem(UMUBlocks.ASH_FENCE_GATE.get(), new Item.Properties().group(UMUItemGroups.DECORATIONS)));
	public static final RegistryObject<Item> SAKURA_DOOR = ITEMS.register("sakura_door", () -> new TallBlockItem(UMUBlocks.SAKURA_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> ASH_DOOR = ITEMS.register("ash_door", () -> new TallBlockItem(UMUBlocks.ASH_DOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> SAKURA_TRAPDOOR = ITEMS.register("sakura_trapdoor", () -> new BlockItem(UMUBlocks.SAKURA_TRAPDOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> ASH_TRAPDOOR = ITEMS.register("ash_trapdoor", () -> new BlockItem(UMUBlocks.ASH_TRAPDOOR.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> SAKURA_BUTTON = ITEMS.register("sakura_button", () -> new BlockItem(UMUBlocks.SAKURA_BUTTON.get(), new Item.Properties().group(UMUItemGroups.REDSTONE)));
	public static final RegistryObject<Item> ASH_BUTTON = ITEMS.register("ash_button", () -> new BlockItem(UMUBlocks.ASH_BUTTON.get(), new Item.Properties().group(UMUItemGroups.REDSTONE)));
	public static final RegistryObject<Item> SAKURA_PRESSURE_PLATE = ITEMS.register("sakura_pressure_plate", () -> new BlockItem(UMUBlocks.SAKURA_PRESSURE_PLATE.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> ASH_PRESSURE_PLATE = ITEMS.register("ash_pressure_plate", () -> new BlockItem(UMUBlocks.ASH_PRESSURE_PLATE.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> SAKURA_SIGN = ITEMS.register("sakura_sign", () -> new SignItem(new Item.Properties().maxStackSize(16).group(ItemGroup.DECORATIONS), UMUBlocks.SAKURA_SIGN.get(), UMUBlocks.SAKURA_WALL_SIGN.get()));
	public static final RegistryObject<Item> ASH_SIGN = ITEMS.register("ash_sign", () -> new SignItem(new Item.Properties().maxStackSize(16).group(ItemGroup.DECORATIONS), UMUBlocks.ASH_SIGN.get(), UMUBlocks.ASH_WALL_SIGN.get()));

	public static final RegistryObject<Item> OAK_BRACE = ITEMS.register("oak_brace", () -> new BlockItem(UMUBlocks.OAK_BRACE.get(), new Item.Properties().group(UMUItemGroups.DECORATIONS)));

	public static final RegistryObject<Item> OAK_POST = ITEMS.register("oak_post", () -> new BlockItem(UMUBlocks.OAK_POST.get(), new Item.Properties().group(UMUItemGroups.DECORATIONS)));

	public static final RegistryObject<Item> OAK_VERTICAL_SLAB = ITEMS.register("oak_vertical_slab", () -> new BlockItem(UMUBlocks.OAK_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SPRUCE_VERTICAL_SLAB = ITEMS.register("spruce_vertical_slab", () -> new BlockItem(UMUBlocks.SPRUCE_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BIRCH_VERTICAL_SLAB = ITEMS.register("birch_vertical_slab", () -> new BlockItem(UMUBlocks.BIRCH_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> JUNGLE_VERTICAL_SLAB = ITEMS.register("jungle_vertical_slab", () -> new BlockItem(UMUBlocks.JUNGLE_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ACACIA_VERTICAL_SLAB = ITEMS.register("acacia_vertical_slab", () -> new BlockItem(UMUBlocks.ACACIA_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DARK_OAK_VERTICAL_SLAB = ITEMS.register("dark_oak_vertical_slab", () -> new BlockItem(UMUBlocks.DARK_OAK_VERTICAL_SLAB.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));

	public static final RegistryObject<Item> TATAMI = ITEMS.register("tatami", () -> new BlockItem(UMUBlocks.TATAMI.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));
	public static final RegistryObject<Item> SHOJI = ITEMS.register("shoji", () -> new BlockItem(UMUBlocks.SHOJI.get(), new Item.Properties().group(UMUItemGroups.FURNITURE)));

	public static final RegistryObject<Item> PLASTER = ITEMS.register("plaster", () -> new BlockItem(UMUBlocks.PLASTER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> WHITE_BRICKS = ITEMS.register("white_bricks", () -> new BlockItem(UMUBlocks.WHITE_BRICKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SANDSTONE_BRICKS = ITEMS.register("sandstone__bricks", () -> new BlockItem(UMUBlocks.SANDSTONE_BRICKS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));

	public static final RegistryObject<Item> PLASTER_HALF_TIMBER_NONE = ITEMS.register("plaster_half_timber_none", () -> new BlockItem(UMUBlocks.PLASTER_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PLASTER_HALF_TIMBER_POSITIVE = ITEMS.register("plaster_half_timber_positive", () -> new BlockItem(UMUBlocks.PLASTER_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PLASTER_HALF_TIMBER_NEGATIVE = ITEMS.register("plaster_half_timber_negative", () -> new BlockItem(UMUBlocks.PLASTER_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PLASTER_HALF_TIMBER_CROSS = ITEMS.register("plaster_half_timber_cross", () -> new BlockItem(UMUBlocks.PLASTER_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PLASTER_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("plaster_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.PLASTER_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));

	public static final RegistryObject<Item> TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> WHITE_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("white_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.WHITE_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> WHITE_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("white_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.WHITE_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> WHITE_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("white_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.WHITE_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> WHITE_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("white_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.WHITE_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> WHITE_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("white_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.WHITE_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ORANGE_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("orange_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.ORANGE_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ORANGE_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("orange_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.ORANGE_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ORANGE_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("orange_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.ORANGE_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ORANGE_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("orange_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.ORANGE_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ORANGE_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("orange_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.ORANGE_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> MAGENTA_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("magenta_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.MAGENTA_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> MAGENTA_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("magenta_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.MAGENTA_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> MAGENTA_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("magenta_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.MAGENTA_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> MAGENTA_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("magenta_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.MAGENTA_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> MAGENTA_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("magenta_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.MAGENTA_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_BLUE_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("light_blue_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.LIGHT_BLUE_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_BLUE_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("light_blue_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.LIGHT_BLUE_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_BLUE_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("light_blue_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.LIGHT_BLUE_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_BLUE_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("light_blue_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.LIGHT_BLUE_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_BLUE_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("light_blue_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.LIGHT_BLUE_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> YELLOW_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("yellow_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.YELLOW_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> YELLOW_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("yellow_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.YELLOW_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> YELLOW_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("yellow_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.YELLOW_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> YELLOW_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("yellow_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.YELLOW_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> YELLOW_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("yellow_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.YELLOW_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIME_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("lime_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.LIME_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIME_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("lime_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.LIME_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIME_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("lime_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.LIME_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIME_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("lime_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.LIME_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIME_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("lime_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.LIME_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PINK_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("pink_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.PINK_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PINK_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("pink_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.PINK_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PINK_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("pink_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.PINK_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PINK_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("pink_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.PINK_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PINK_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("pink_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.PINK_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GRAY_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("gray_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.GRAY_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GRAY_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("gray_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.GRAY_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GRAY_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("gray_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.GRAY_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GRAY_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("gray_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.GRAY_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GRAY_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("gray_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.GRAY_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_GRAY_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("light_gray_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.LIGHT_GRAY_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_GRAY_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("light_gray_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.LIGHT_GRAY_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_GRAY_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("light_gray_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.LIGHT_GRAY_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_GRAY_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("light_gray_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.LIGHT_GRAY_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> LIGHT_GRAY_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("light_gray_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.LIGHT_GRAY_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CYAN_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("cyan_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.CYAN_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CYAN_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("cyan_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.CYAN_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CYAN_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("cyan_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.CYAN_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CYAN_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("cyan_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.CYAN_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> CYAN_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("cyan_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.CYAN_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PURPLE_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("purple_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.PURPLE_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PURPLE_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("purple_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.PURPLE_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PURPLE_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("purple_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.PURPLE_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PURPLE_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("purple_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.PURPLE_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> PURPLE_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("purple_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.PURPLE_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLUE_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("blue_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.BLUE_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLUE_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("blue_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.BLUE_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLUE_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("blue_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.BLUE_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLUE_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("blue_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.BLUE_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLUE_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("blue_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.BLUE_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BROWN_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("brown_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.BROWN_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BROWN_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("brown_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.BROWN_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BROWN_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("brown_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.BROWN_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BROWN_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("brown_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.BROWN_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BROWN_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("brown_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.BROWN_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GREEN_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("green_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.GREEN_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GREEN_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("green_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.GREEN_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GREEN_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("green_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.GREEN_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GREEN_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("green_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.GREEN_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> GREEN_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("green_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.GREEN_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RED_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("red_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.RED_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RED_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("red_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.RED_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RED_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("red_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.RED_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RED_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("red_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.RED_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RED_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("red_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.RED_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLACK_TERRACOTTA_HALF_TIMBER_NONE = ITEMS.register("black_terracotta_half_timber_none", () -> new BlockItem(UMUBlocks.BLACK_TERRACOTTA_HALF_TIMBER_NONE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLACK_TERRACOTTA_HALF_TIMBER_POSITIVE = ITEMS.register("black_terracotta_half_timber_positive", () -> new BlockItem(UMUBlocks.BLACK_TERRACOTTA_HALF_TIMBER_POSITIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLACK_TERRACOTTA_HALF_TIMBER_NEGATIVE = ITEMS.register("black_terracotta_half_timber_negative", () -> new BlockItem(UMUBlocks.BLACK_TERRACOTTA_HALF_TIMBER_NEGATIVE.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLACK_TERRACOTTA_HALF_TIMBER_CROSS = ITEMS.register("black_terracotta_half_timber_cross", () -> new BlockItem(UMUBlocks.BLACK_TERRACOTTA_HALF_TIMBER_CROSS.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BLACK_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER = ITEMS.register("black_terracotta_half_timber_pattern_flower", () -> new BlockItem(UMUBlocks.BLACK_TERRACOTTA_HALF_TIMBER_PATTERN_FLOWER.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));

	public static final RegistryObject<Item> WHITE_BRICKS_PLANTER = ITEMS.register("white_bricks_planter", () -> new BlockItem(UMUBlocks.WHITE_BRICKS_PLANTER.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

	public static final RegistryObject<Item> FLOWER_BASKET = ITEMS.register("flower_basket", () -> new BlockItem(UMUBlocks.FLOWER_BASKET.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> RED_FLOWER_BASKET = ITEMS.register("red_flower_basket", () -> new BlockItem(UMUBlocks.RED_FLOWER_BASKET.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> YELLOW_FLOWER_BASKET = ITEMS.register("yellow_flower_basket", () -> new BlockItem(UMUBlocks.YELLOW_FLOWER_BASKET.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> WHITE_FLOWER_BASKET = ITEMS.register("white_flower_basket", () -> new BlockItem(UMUBlocks.WHITE_FLOWER_BASKET.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> BLUE_FLOWER_BASKET = ITEMS.register("blue_flower_basket", () -> new BlockItem(UMUBlocks.BLUE_FLOWER_BASKET.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> COLORFUL_FLOWER_BASKET = ITEMS.register("colorful_flower_basket", () -> new BlockItem(UMUBlocks.COLORFUL_FLOWER_BASKET.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> BUSH_FLOWER_BASKET = ITEMS.register("bush_flower_basket", () -> new BlockItem(UMUBlocks.BUSH_FLOWER_BASKET.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> SUSPICIOUS_FLOWER_BASKET = ITEMS.register("suspicious_flower_basket", () -> new BlockItem(UMUBlocks.SUSPICIOUS_FLOWER_BASKET.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> NETHER_FLOWER_BASKET = ITEMS.register("nether_flower_basket", () -> new BlockItem(UMUBlocks.NETHER_FLOWER_BASKET.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> WOODEN_BOX_OLD = ITEMS.register("wooden_box_old", () -> new BlockItem(UMUBlocks.WOODEN_BOX_OLD.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	public static final RegistryObject<Item> WOODEN_BOX = ITEMS.register("wooden_box", () -> new BlockItem(UMUBlocks.WOODEN_BOX.get(), new Item.Properties().group(UMUItemGroups.DECORATIONS)));
	public static final RegistryObject<Item> THIN_WOODEN_BOX = ITEMS.register("thin_wooden_box", () -> new BlockItem(UMUBlocks.THIN_WOODEN_BOX.get(), new Item.Properties().group(UMUItemGroups.DECORATIONS)));
	public static final RegistryObject<Item> QUARTZ_COLUMN = ITEMS.register("quartz_column", () -> new BlockItem(UMUBlocks.QUARTZ_COLUMN.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

	// public static final RegistryObject<Item> BUMPKIN = ITEMS.register("bumpkin", () -> new BlockItem(UMUBlocks.BUMPKIN.get(), new Item.Properties().group(UMUItemGroups.BUILDING_BLOCKS)));
}

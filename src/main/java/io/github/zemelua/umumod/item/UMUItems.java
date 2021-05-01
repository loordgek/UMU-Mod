package io.github.zemelua.umumod.item;

import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.block.UMUBlocks;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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

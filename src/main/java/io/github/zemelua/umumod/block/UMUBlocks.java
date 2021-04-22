package io.github.zemelua.umumod.block;

import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.block.blockstateproperty.ColumnBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.OakTree;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UMUBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UMUMod.MODID);

	public static final RegistryObject<Block> SAKURA_PLANKS = BLOCKS.register("sakura_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SAKURA_SAPLING = BLOCKS.register("sakura_sapling", () -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> SAKURA_LOG = BLOCKS.register("sakura_log", () -> createLogBlock(MaterialColor.WHITE_TERRACOTTA, MaterialColor.BROWN));
	public static final RegistryObject<Block> SAKURA_WOOD = BLOCKS.register("sakura_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA)));
	public static final RegistryObject<Block> STRIPPED_SAKURA_LOG = BLOCKS.register("stripped_sakura_log", () -> createLogBlock(MaterialColor.WHITE_TERRACOTTA, MaterialColor.WHITE_TERRACOTTA));
	public static final RegistryObject<Block> STRIPPED_SAKURA_WOOD = BLOCKS.register("stripped_sakura_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SAKURA_LEAVES = BLOCKS.register("sakura_leaves", UMUBlocks::createLeavesBlock);
	public static final RegistryObject<Block> SAKURA_STAIRS = BLOCKS.register("sakura_stairs", () -> new StairsBlock(() -> SAKURA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(SAKURA_PLANKS.get())));
	public static final RegistryObject<Block> SAKURA_SIGN = BLOCKS.register("sakura_sign", () -> new StandingSignBlock(AbstractBlock.Properties.create(Material.WOOD, SAKURA_PLANKS.get().getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), UMUWoodType.SAKURA));
	public static final RegistryObject<Block> SAKURA_DOOR = BLOCKS.register("sakura_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD, SAKURA_PLANKS.get().getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final RegistryObject<Block> SAKURA_WALL_SIGN = BLOCKS.register("sakura_wall_sign", () -> new WallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(SAKURA_SIGN), UMUWoodType.SAKURA));
	public static final RegistryObject<Block> SAKURA_PRESSURE_PLATE = BLOCKS.register("sakura_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, SAKURA_PLANKS.get().getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SAKURA_FENCE = BLOCKS.register("sakura_fence", () -> new FenceBlock(AbstractBlock.Properties.create(Material.WOOD, SAKURA_PLANKS.get().getMaterialColor()).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SAKURA_TRAPDOOR = BLOCKS.register("sakura_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid().setAllowsSpawn(UMUBlocks::neverAllowSpawn)));
	public static final RegistryObject<Block> SAKURA_FENCE_GATE = BLOCKS.register("sakura_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.WOOD, SAKURA_PLANKS.get().getMaterialColor()).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> POTTED_SAKURA_SAPLING = BLOCKS.register("potted_sakura_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SAKURA_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
	public static final RegistryObject<Block> SAKURA_BUTTON = BLOCKS.register("sakura_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SAKURA_SLAB = BLOCKS.register("sakura_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> OAK_VERTICAL_SLAB = BLOCKS.register("oak_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SPRUCE_VERTICAL_SLAB = BLOCKS.register("spruce_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BIRCH_VERTICAL_SLAB = BLOCKS.register("birch_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> JUNGLE_VERTICAL_SLAB = BLOCKS.register("jungle_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ACACIA_VERTICAL_SLAB = BLOCKS.register("acacia_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DARK_OAK_VERTICAL_SLAB = BLOCKS.register("dark_oak_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> WOODEN_BOX = BLOCKS.register("wooden_box", () -> new WoodenBoxBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(4.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> QUARTZ_COLUMN = BLOCKS.register("quartz_column", () -> new ColumnBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	// public static final RegistryObject<Block> BUMPKIN = BLOCKS.register("bumpkin", () -> new BumpkinBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));

	private static Boolean neverAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
		return false;
	}

	private static Boolean allowsSpawnOnLeaves(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
		return entity == EntityType.OCELOT || entity == EntityType.PARROT;
	}

	private static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor barkColor) {
		return new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, (state) -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	}

	private static LeavesBlock createLeavesBlock() {
		return new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid().setAllowsSpawn(UMUBlocks::allowsSpawnOnLeaves).setSuffocates(UMUBlocks::isntSolid).setBlocksVision(UMUBlocks::isntSolid));
	}

	private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
		return false;
	}
}

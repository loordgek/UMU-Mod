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
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class UMUBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UMUMod.MODID);

	public static final RegistryObject<Block> SAKURA_LOG = BLOCKS.register("sakura_log", createLogBlock(MaterialColor.WHITE_TERRACOTTA, MaterialColor.BROWN));
	public static final RegistryObject<Block> ASH_LOG = BLOCKS.register("ash_log", createLogBlock(MaterialColor.SNOW, MaterialColor.QUARTZ));
	public static final RegistryObject<Block> SAKURA_WOOD = BLOCKS.register("sakura_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ASH_WOOD = BLOCKS.register("ash_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.QUARTZ).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_SAKURA_LOG = BLOCKS.register("stripped_sakura_log", createLogBlock(MaterialColor.WHITE_TERRACOTTA, MaterialColor.WHITE_TERRACOTTA));
	public static final RegistryObject<Block> STRIPPED_ASH_LOG = BLOCKS.register("stripped_ash_log", createLogBlock(MaterialColor.SNOW, MaterialColor.SNOW));
	public static final RegistryObject<Block> STRIPPED_SAKURA_WOOD = BLOCKS.register("stripped_sakura_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> STRIPPED_ASH_WOOD = BLOCKS.register("stripped_ash_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SAKURA_SAPLING = BLOCKS.register("sakura_sapling", () -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> ASH_SAPLING = BLOCKS.register("ash_sapling", () -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> POTTED_SAKURA_SAPLING = BLOCKS.register("potted_sakura_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), SAKURA_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
	public static final RegistryObject<Block> POTTED_ASH_SAPLING = BLOCKS.register("potted_ash_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT.delegate.get(), ASH_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance().notSolid()));
	public static final RegistryObject<Block> SAKURA_LEAVES = BLOCKS.register("sakura_leaves", createLeavesBlock());
	public static final RegistryObject<Block> ASH_LEAVES = BLOCKS.register("ash_leaves", createLeavesBlock());
	public static final RegistryObject<Block> SAKURA_PLANKS = BLOCKS.register("sakura_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WHITE_TERRACOTTA).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ASH_PLANKS = BLOCKS.register("ash_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SAKURA_SLAB = BLOCKS.register("sakura_slab", () -> new SlabBlock(AbstractBlock.Properties.from(SAKURA_PLANKS.get())));
	public static final RegistryObject<Block> ASH_SLAB = BLOCKS.register("ash_slab", () -> new SlabBlock(AbstractBlock.Properties.from(ASH_PLANKS.get())));
	public static final RegistryObject<Block> SAKURA_STAIRS = BLOCKS.register("sakura_stairs", () -> new StairsBlock(() -> SAKURA_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(SAKURA_PLANKS.get())));
	public static final RegistryObject<Block> ASH_STAIRS = BLOCKS.register("ash_stairs", () -> new StairsBlock(() -> ASH_PLANKS.get().getDefaultState(), AbstractBlock.Properties.from(ASH_PLANKS.get())));
	public static final RegistryObject<Block> SAKURA_FENCE = BLOCKS.register("sakura_fence", () -> new FenceBlock(AbstractBlock.Properties.from(SAKURA_PLANKS.get())));
	public static final RegistryObject<Block> ASH_FENCE = BLOCKS.register("ash_fence", () -> new FenceBlock(AbstractBlock.Properties.from(ASH_PLANKS.get())));
	public static final RegistryObject<Block> SAKURA_FENCE_GATE = BLOCKS.register("sakura_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(SAKURA_PLANKS.get())));
	public static final RegistryObject<Block> ASH_FENCE_GATE = BLOCKS.register("ash_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.from(ASH_PLANKS.get())));
	public static final RegistryObject<Block> SAKURA_DOOR = BLOCKS.register("sakura_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD, SAKURA_PLANKS.get().getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final RegistryObject<Block> ASH_DOOR = BLOCKS.register("ash_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD, ASH_PLANKS.get().getMaterialColor()).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
	public static final RegistryObject<Block> SAKURA_TRAPDOOR = BLOCKS.register("sakura_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PINK_TERRACOTTA).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid().setAllowsSpawn(UMUBlocks::neverAllowSpawn)));
	public static final RegistryObject<Block> ASH_TRAPDOOR = BLOCKS.register("ash_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid().setAllowsSpawn(UMUBlocks::neverAllowSpawn)));
	public static final RegistryObject<Block> SAKURA_BUTTON = BLOCKS.register("sakura_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ASH_BUTTON = BLOCKS.register("ash_button", () -> new WoodButtonBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SAKURA_PRESSURE_PLATE = BLOCKS.register("sakura_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, SAKURA_PLANKS.get().getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ASH_PRESSURE_PLATE = BLOCKS.register("ash_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, ASH_PLANKS.get().getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SAKURA_SIGN = BLOCKS.register("sakura_sign", () -> new StandingSignBlock(AbstractBlock.Properties.create(Material.WOOD, SAKURA_PLANKS.get().getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), UMUWoodType.SAKURA));
	public static final RegistryObject<Block> ASH_SIGN = BLOCKS.register("ash_sign", () -> new StandingSignBlock(AbstractBlock.Properties.create(Material.WOOD, ASH_PLANKS.get().getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), UMUWoodType.ASH));
	public static final RegistryObject<Block> SAKURA_WALL_SIGN = BLOCKS.register("sakura_wall_sign", () -> new WallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(SAKURA_SIGN), UMUWoodType.SAKURA));
	public static final RegistryObject<Block> ASH_WALL_SIGN = BLOCKS.register("ash_wall_sign", () -> new WallSignBlock(AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(ASH_SIGN), UMUWoodType.ASH));

	public static final RegistryObject<Block> OAK_POST = BLOCKS.register("oak_post", () -> new PostBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_WOOD)));

	public static final RegistryObject<Block> OAK_VERTICAL_SLAB = BLOCKS.register("oak_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SPRUCE_VERTICAL_SLAB = BLOCKS.register("spruce_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BIRCH_VERTICAL_SLAB = BLOCKS.register("birch_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> JUNGLE_VERTICAL_SLAB = BLOCKS.register("jungle_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ACACIA_VERTICAL_SLAB = BLOCKS.register("acacia_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DARK_OAK_VERTICAL_SLAB = BLOCKS.register("dark_oak_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> TATAMI = BLOCKS.register("tatami", () -> new TatamiBlock(AbstractBlock.Properties.create(Material.BAMBOO, MaterialColor.FOLIAGE).tickRandomly().hardnessAndResistance(1.5F).sound(SoundType.BAMBOO)));
	public static final RegistryObject<Block> SHOJI = BLOCKS.register("shoji", () -> new SlidingDoorBlock(AbstractBlock.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> KOSHITSUKI_SHOJI = BLOCKS.register("koshitsuki_shoji", () -> new SlidingDoorBlock(AbstractBlock.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> YUKIMI_SHOJI = BLOCKS.register("yukimi_shoji", () -> new SlidingDoorBlock(AbstractBlock.Properties.from(Blocks.OAK_DOOR)));
	public static final RegistryObject<Block> FUSUMA = BLOCKS.register("fusuma", () -> new SlidingDoorBlock(AbstractBlock.Properties.from(Blocks.OAK_DOOR)));

	public static final RegistryObject<Block> PLASTER = BLOCKS.register("plaster", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(1.8F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PLASTER_HALF_TIMBER_NONE = BLOCKS.register("plaster_half_timber_none", () -> new ConnectionSwitchBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BROWN).hardnessAndResistance(1.8F, 6.0F).sound(SoundType.STONE)));
	public static final RegistryObject<Block> PLASTER_HALF_TIMBER_POSITIVE = BLOCKS.register("plaster_half_timber_positive", () -> new ConnectionSwitchBlock(AbstractBlock.Properties.from(PLASTER_HALF_TIMBER_NONE.get())));
	public static final RegistryObject<Block> PLASTER_HALF_TIMBER_NEGATIVE = BLOCKS.register("plaster_half_timber_negative", () -> new ConnectionSwitchBlock(AbstractBlock.Properties.from(PLASTER_HALF_TIMBER_NONE.get())));
	public static final RegistryObject<Block> PLASTER_HALF_TIMBER_CROSS = BLOCKS.register("plaster_half_timber_cross", () -> new ConnectionSwitchBlock(AbstractBlock.Properties.from(PLASTER_HALF_TIMBER_NONE.get())));
	public static final RegistryObject<Block> PLASTER_HALF_TIMBER_PATTERN_FLOWER = BLOCKS.register("plaster_half_timber_pattern_flower", () -> new ConnectionSwitchBlock(AbstractBlock.Properties.from(PLASTER_HALF_TIMBER_NONE.get())));

	public static final RegistryObject<Block> WOODEN_BOX_OLD = BLOCKS.register("wooden_box_old", () -> new WoodenBoxBlockOld(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(4.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> WOODEN_BOX = BLOCKS.register("wooden_box", () -> new WoodenBoxBlock(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(4.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> THIN_WOODEN_BOX = BLOCKS.register("thin_wooden_box", () -> new ThinWoodenBoxBlock(AbstractBlock.Properties.from(WOODEN_BOX.get())));

	public static final RegistryObject<Block> QUARTZ_COLUMN = BLOCKS.register("quartz_column", () -> new ColumnBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	// public static final RegistryObject<Block> BUMPKIN = BLOCKS.register("bumpkin", () -> new BumpkinBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));

	@SubscribeEvent
	public static void registerPottedFlower(final RegistryEvent.Register<Block> event) {
		if (Blocks.FLOWER_POT != null) {
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SAKURA_SAPLING.getId(), POTTED_SAKURA_SAPLING);
			((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ASH_SAPLING.getId(), POTTED_ASH_SAPLING);
		}
	}

	private static Boolean neverAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
		return false;
	}

	private static Boolean allowsSpawnOnLeaves(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
		return entity == EntityType.OCELOT || entity == EntityType.PARROT;
	}

	private static Supplier<RotatedPillarBlock> createLogBlock(MaterialColor topColor, MaterialColor barkColor) {
		return () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, (state) -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
	}

	private static Supplier<LeavesBlock> createLeavesBlock() {
		return () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid().setAllowsSpawn(UMUBlocks::allowsSpawnOnLeaves).setSuffocates(UMUBlocks::isntSolid).setBlocksVision(UMUBlocks::isntSolid));
	}

	private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
		return false;
	}
}

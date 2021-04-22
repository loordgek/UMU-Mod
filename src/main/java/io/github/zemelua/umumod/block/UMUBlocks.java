package io.github.zemelua.umumod.block;

import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.block.blockstateproperty.ColumnBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UMUBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UMUMod.MODID);

	public static final RegistryObject<Block> OAK_VERTICAL_SLAB = BLOCKS.register("oak_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SPRUCE_VERTICAL_SLAB = BLOCKS.register("spruce_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> BIRCH_VERTICAL_SLAB = BLOCKS.register("birch_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> JUNGLE_VERTICAL_SLAB = BLOCKS.register("jungle_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> ACACIA_VERTICAL_SLAB = BLOCKS.register("acacia_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DARK_OAK_VERTICAL_SLAB = BLOCKS.register("dark_oak_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> WOODEN_BOX = BLOCKS.register("wooden_box", () -> new WoodenBoxBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(4.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> QUARTZ_COLUMN = BLOCKS.register("quartz_column", () -> new ColumnBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	// public static final RegistryObject<Block> BUMPKIN = BLOCKS.register("bumpkin", () -> new BumpkinBlock(AbstractBlock.Properties.create(Material.GOURD, MaterialColor.ADOBE).hardnessAndResistance(1.5F).sound(SoundType.WOOD)));
}

package io.github.zemelua.umumod.block;

import io.github.zemelua.umumod.UMUMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UMUBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UMUMod.MODID);

	public static final RegistryObject<Block> WHITE_PLANKS = BLOCKS.register("white_planks", () -> new Block(Block.Properties.create(Material.WOOD, MaterialColor.SNOW).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
}
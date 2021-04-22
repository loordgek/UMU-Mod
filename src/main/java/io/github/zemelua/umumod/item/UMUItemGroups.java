package io.github.zemelua.umumod.item;

import io.github.zemelua.umumod.block.UMUBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class UMUItemGroups {
	public static final ItemGroup BUILDING_BLOCKS = new ItemGroup("buildingBlocks") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(UMUBlocks.SAKURA_PLANKS.get());
		}
	};
	public static final ItemGroup DECORATIONS = new ItemGroup("decorations") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(UMUItems.SAKURA_SAPLING.get());
		}
	};
	public static final ItemGroup FURNITURE = new ItemGroup("furniture") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Blocks.LANTERN);
		}
	};
	public static final ItemGroup REDSTONE = new ItemGroup("redstone") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Blocks.REDSTONE_WIRE);
		}
	};
}

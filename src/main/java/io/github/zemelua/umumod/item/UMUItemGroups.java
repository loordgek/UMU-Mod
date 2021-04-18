package io.github.zemelua.umumod.item;

import io.github.zemelua.umumod.block.UMUBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class UMUItemGroups {
	public static final ItemGroup BUILDING_BLOCKS = (new ItemGroup("buildingBlocks") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(UMUBlocks.BLACK_PLANKS.get());
		}
	});
}

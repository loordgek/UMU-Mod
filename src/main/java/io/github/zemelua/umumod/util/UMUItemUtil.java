package io.github.zemelua.umumod.util;

import io.github.zemelua.umumod.capability.UMUCapabilities;
import io.github.zemelua.umumod.fluid.FluidTankHandler;
import io.github.zemelua.umumod.fluid.IFluidTankHandler;
import io.github.zemelua.umumod.item.UMUItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public final class UMUItemUtil {
	private UMUItemUtil() {
		throw new AssertionError();
	}

	public static boolean canCombine(ItemStack stack1, ItemStack stack2) {
		if (stack1.getItem() != stack2.getItem()) {
			return false;
		} else if (stack1.getDamage() != stack2.getDamage()) {
			return false;
		} else if (stack1.getCount() > stack1.getMaxStackSize()) {
			return false;
		} else {
			return ItemStack.areItemStackTagsEqual(stack1, stack2);
		}
	}

	public static IItemHandler getBackpackInventory(ItemStack backpack) {
		if (backpack.getItem() == UMUItems.BACKPACK.get() || backpack.getItem() == UMUItems.FUNCTIONAL_BACKPACK.get()) {
			return backpack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.EAST)
					.orElse(new ItemStackHandler(0));
		}

		return new ItemStackHandler(0);
	}

	public static IItemHandler getQuiverInventory(ItemStack quiver) {
		if (quiver.getItem() == UMUItems.QUIVER.get() || quiver.getItem() == UMUItems.FUNCTIONAL_BACKPACK.get()) {
			return quiver.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.SOUTH)
					.orElse(new ItemStackHandler(9));
		}

		return new ItemStackHandler(0);
	}

	public static IFluidTankHandler getTankCistern(ItemStack tank) {
		if (tank.getItem() == UMUItems.TANK.get() || tank.getItem() == UMUItems.TANK.get()) {
			return tank.getCapability(UMUCapabilities.FLUID_TANK_HANDLER_CAPABILITY, Direction.DOWN)
					.orElse(new FluidTankHandler(4));
		}

		return new FluidTankHandler(0);
	}

	public static int getBackpackSize(ItemStack backpack) {
		if (backpack.getItem() == UMUItems.BACKPACK.get() || backpack.getItem() == UMUItems.FUNCTIONAL_BACKPACK.get()) {
			return EnchantmentHelper.getEnchantmentLevel(Enchantments.BINDING_CURSE, backpack);
		}

		return -1;
	}
}

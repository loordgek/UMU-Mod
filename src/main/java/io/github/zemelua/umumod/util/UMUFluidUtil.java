package io.github.zemelua.umumod.util;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;

public class UMUFluidUtil {
	public static FluidTank EMPTY_TANK = new FluidTank(3);
	public static FluidTank emptyTank() {
		return new FluidTank(3);
	}

	public static FluidStack getFluidForItemStack(ItemStack cupStack) {
		Item cupItem = cupStack.getItem();

		if (cupItem == Items.WATER_BUCKET) {
			return new FluidStack(Fluids.WATER, 3);
		} else if (cupItem == Items.LAVA_BUCKET) {
			return new FluidStack(Fluids.LAVA, 3);
		} else if (cupItem == Items.POTION) {
			return new FluidStack(Fluids.WATER, 1);
		}

		return FluidStack.EMPTY;
	}

	public static ItemStack getScoopedCup(ItemStack fullCupStack, int amount) {
		Item fullCupItem = fullCupStack.getItem();

		if (fullCupItem == Items.WATER_BUCKET || fullCupItem == Items.LAVA_BUCKET) {
			return new ItemStack(Items.BUCKET, fullCupStack.getCount());
		} else if (fullCupItem == Items.POTION) {
			return new ItemStack(Items.GLASS_BOTTLE, fullCupStack.getCount());
		}

		return ItemStack.EMPTY;
	}

	public static ItemStack scoopFluidForTank(ItemStack cupStack, FluidTank tank) {
		Item cupItem = cupStack.getItem();

		if (cupItem == Items.BUCKET) {
			if (tank.drain(3, IFluidHandler.FluidAction.SIMULATE).getAmount() == 3) {
				FluidStack fluidStack = tank.drain(3, IFluidHandler.FluidAction.EXECUTE);
				cupStack.split(1);
				return FluidUtil.getFilledBucket(fluidStack);
			}
		} else if (cupItem == Items.GLASS_BOTTLE) {
			FluidStack drainedStack = tank.drain(1, IFluidHandler.FluidAction.SIMULATE);
			if (drainedStack.getAmount() >= 1 && drainedStack.getFluid() == Fluids.WATER) {
				tank.drain(1, IFluidHandler.FluidAction.EXECUTE);
				cupStack.split(1);
				return Items.POTION.getDefaultInstance();
			}
		}

		return ItemStack.EMPTY;
	}

	public static ItemStack pourFluidToTank(ItemStack cupStack, FluidTank tank) {
		FluidStack fluidStack = getFluidForItemStack(cupStack);

		if (!fluidStack.isEmpty() && tank.fill(fluidStack, IFluidHandler.FluidAction.SIMULATE) == fluidStack.getAmount()) {
			int amount = tank.fill(fluidStack, IFluidHandler.FluidAction.EXECUTE);
			ItemStack splitStack = cupStack.split(1);
			return getScoopedCup(splitStack, amount);
		}

		return ItemStack.EMPTY;
	}
}

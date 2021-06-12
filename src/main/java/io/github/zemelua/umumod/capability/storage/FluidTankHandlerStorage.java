package io.github.zemelua.umumod.capability.storage;

import io.github.zemelua.umumod.fluid.FluidTankHandler;
import io.github.zemelua.umumod.fluid.IFluidTankHandler;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nullable;

public class FluidTankHandlerStorage<T extends IFluidTankHandler> implements Capability.IStorage<T> {
	@Nullable
	@Override
	public INBT writeNBT(Capability<T> capability, T instance, Direction side) {
		ListNBT tankTagList = new ListNBT();

		for (int i = 0; i < instance.getTanks(); i++) {
			FluidStack fluidStack = instance.getFluidInTank(i);
			CompoundNBT tankTag = new CompoundNBT();
			fluidStack.writeToNBT(tankTag);
			tankTag.putInt("Capacity", instance.getTankCapacity(i));
			tankTagList.add(tankTag);
		}

		return tankTagList;
	}

	@Override
	public void readNBT(Capability<T> capability, T instance, Direction side, INBT nbt) {
		ListNBT tankTagList = (ListNBT) nbt;

		for (int i = 0; i < tankTagList.size(); i++) {
			CompoundNBT tankTag = tankTagList.getCompound(i);
			FluidTankHandler tankHandler = (FluidTankHandler) instance;
			tankHandler.setTankCapacity(i, tankTag.getInt("Capacity"));
			tankHandler.setTankFromNBT(i, tankTag);
		}
	}
}

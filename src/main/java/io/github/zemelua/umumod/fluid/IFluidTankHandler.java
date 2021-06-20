package io.github.zemelua.umumod.fluid;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nonnull;

public interface IFluidTankHandler extends IFluidHandler {
	public void setTankCapacity(int tank, int capacity);

	public void setTankFromNBT(int slot, CompoundNBT nbt);

	public void setStackInTank(int tank, @Nonnull FluidStack stack);

	public int fillInTank(int tank, FluidStack resource, FluidAction action);

	public FluidStack drainInTank(int tank, FluidStack resource, FluidAction action);

	public FluidStack drainInTank(int tank, int maxDrain, FluidAction action);
}

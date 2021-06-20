package io.github.zemelua.umumod.fluid;

import io.github.zemelua.umumod.util.UMUFluidUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidTank;

import javax.annotation.Nonnull;
import java.util.Collections;

public class FluidTankHandler implements IFluidTankHandler {
	public NonNullList<FluidTank> tanks;

	public FluidTankHandler() {
		this(1);
	}

	public FluidTankHandler(int size) {
		this(NonNullList.withSize(size, UMUFluidUtil.emptyTank()));
	}

	public FluidTankHandler(NonNullList<FluidTank> tanks) {
		this.tanks = tanks;
	}

	@Override
	public int getTanks() {
		return this.tanks.size();
	}

	public void setSize(int size) {
		tanks = NonNullList.withSize(size, UMUFluidUtil.emptyTank());
	}

	@Override
	public void setTankFromNBT(int slot, CompoundNBT nbt) {
		this.tanks.get(slot).readFromNBT(nbt);
	}

	@Override
	public void setStackInTank(int tank, @Nonnull FluidStack stack) {
		this.validateTankIndex(tank);
		FluidTank fluidTank = new FluidTank(3);
		fluidTank.fill(stack, FluidAction.EXECUTE);
		this.tanks.set(tank, fluidTank);
	}

	@Nonnull
	@Override
	public FluidStack getFluidInTank(int tank) {
		this.validateTankIndex(tank);
		return this.tanks.get(tank).getFluid();
	}

	@Override
	public int getTankCapacity(int tank) {
		validateTankIndex(tank);
		return this.tanks.get(tank).getCapacity();
	}

	@Override
	public void setTankCapacity(int tank, int capacity) {
		this.tanks.get(tank).setCapacity(capacity);
	}

	@Override
	public boolean isFluidValid(int tank, @Nonnull FluidStack stack) {
		return this.tanks.get(tank).isFluidValid(stack);
	}

	@Override
	public int fill(FluidStack resource, FluidAction action) {
		FluidStack copyResource = resource.copy();

		for (FluidTank tank : this.tanks) {
			int amount = tank.fill(copyResource, action);
			int memo = copyResource.getAmount();
			copyResource.setAmount(copyResource.getAmount() - amount);
			Minecraft.getInstance().player.sendChatMessage(String.valueOf(amount) + String.valueOf(memo));
		}

		return copyResource.getAmount();
	}

	@Nonnull
	@Override
	public FluidStack drain(FluidStack resource, FluidAction action) {
		FluidStack copyResource = resource.copy();

		NonNullList<FluidTank> copyTanks = NonNullList.create();
		copyTanks.addAll(this.tanks);
		Collections.reverse(copyTanks);

		for (FluidTank tank : copyTanks) {
			int amount = tank.drain(resource, action).getAmount();
			copyResource.setAmount(copyResource.getAmount() - amount);
		}

		return copyResource;
	}

	@Nonnull
	@Override
	public FluidStack drain(int maxDrain, FluidAction action) {
		int drained = maxDrain;
		FluidStack resource = FluidStack.EMPTY;

		NonNullList<FluidTank> copyTanks = NonNullList.create();
		copyTanks.addAll(this.tanks);
		Collections.reverse(copyTanks);

		for (FluidTank tank : copyTanks) {
			resource = tank.drain(drained, action);
			drained = drained - resource.getAmount();
		}

		return resource;
	}

	@Override
	public int fillInTank(int tank, FluidStack resource, FluidAction action) {
		return this.tanks.get(tank).fill(resource, action);
	}

	@Override
	public FluidStack drainInTank(int tank, FluidStack resource, FluidAction action) {
		return this.tanks.get(tank).drain(resource, action);
	}

	@Override
	public FluidStack drainInTank(int tank, int maxDrain, FluidAction action) {
		return this.tanks.get(tank).drain(maxDrain, action);
	}

	protected void validateTankIndex(int tank) {
		if (tank < 0 || tank >= tanks.size()) {
			throw new RuntimeException("Tank " + tank + " not in valid range - [0," + tanks.size() + ")");
		}
	}
}

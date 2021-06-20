package io.github.zemelua.umumod.inventory.container.element.tank;

import io.github.zemelua.umumod.fluid.FluidTankHandler;
import io.github.zemelua.umumod.fluid.IFluidTankHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;

public class Tank {
	private final int tankIndex;
	private IFluidHandler inventory;
	private int tankNumber;
	private final int xPos;
	private final int yPos;

	public Tank(int tankIndex, IFluidHandler inventory, int xPos, int yPos) {
		this.tankIndex = tankIndex;
		this.inventory = inventory;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public int getXPos() {
		return xPos;
	}

	public int getYPos() {
		return yPos;
	}

	public void setTankNumber(int tankNumber) {
		this.tankNumber = tankNumber;
	}

	public boolean isFluidValid(FluidStack stack) {
		return true;
	}

	public FluidStack getStack() {
		return this.inventory.getFluidInTank(this.tankIndex);
	}

	public FluidTank getTank() {
		return ((FluidTankHandler) this.inventory).tanks.get(this.tankIndex);
	}

	public boolean getHasStack() {
		return !this.getStack().isEmpty();
	}

	public void putStack(FluidStack stack) {
		((IFluidTankHandler) this.inventory).setStackInTank(this.tankIndex, stack);
	}

	public int getTankCapacity() {
		return this.inventory.getTankCapacity(this.tankIndex);
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isEnabled() {
		return true;
	}
}

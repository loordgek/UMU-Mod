package io.github.zemelua.umumod.util;

import net.minecraftforge.fluids.capability.templates.FluidTank;

public class UMUFluidUtil {
	public static FluidTank EMPTY_TANK = new FluidTank(3);
	public static final FluidTank emptyTank() {
		return new FluidTank(3);
	}
}

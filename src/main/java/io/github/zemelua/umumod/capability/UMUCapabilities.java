package io.github.zemelua.umumod.capability;

import io.github.zemelua.umumod.capability.storage.FluidTankHandlerStorage;
import io.github.zemelua.umumod.fluid.FluidTankHandler;
import io.github.zemelua.umumod.fluid.IFluidTankHandler;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class UMUCapabilities {
	@CapabilityInject(IFluidTankHandler.class)
	public static Capability<IFluidTankHandler> FLUID_TANK_HANDLER_CAPABILITY = null;

	public static void register() {
		CapabilityManager.INSTANCE.register(IFluidTankHandler.class, new FluidTankHandlerStorage<>(), FluidTankHandler::new);
	}
}

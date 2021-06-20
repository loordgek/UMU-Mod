package io.github.zemelua.umumod.capability;

import io.github.zemelua.umumod.fluid.FluidTankHandler;
import io.github.zemelua.umumod.fluid.IFluidTankHandler;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FunctionalBackpackCapabilityProvider implements ICapabilitySerializable<CompoundNBT> {
	private IItemHandler backpackInventory = null;
	private IItemHandler quiverInventory = null;
	private IFluidTankHandler tankCistern = null;
	private final LazyOptional<IItemHandler> backpackInventorySupplier = LazyOptional.of(this::getCachedBackpackInventory);
	private final LazyOptional<IItemHandler> quiverInventorySupplier = LazyOptional.of(this::getCachedQuiverInventory);
	private final LazyOptional<IFluidTankHandler> tankCisternSupplier = LazyOptional.of(this::getCachedTankCistern);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (side == null) return LazyOptional.empty();

		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			if (side.getAxis() == Direction.Axis.X) return this.backpackInventorySupplier.cast();
			else if (side.getAxis() == Direction.Axis.Y) return this.quiverInventorySupplier.cast();
		} else if (cap == UMUCapabilities.FLUID_TANK_HANDLER_CAPABILITY) {
			if (side.getAxis() == Direction.Axis.Z) return this.tankCisternSupplier.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT compoundNBT = new CompoundNBT();

		INBT backpackNBT = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.writeNBT(this.getCachedBackpackInventory(), null);
		INBT quiverNBT = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.writeNBT(this.getCachedQuiverInventory(), null);
		INBT tankNBT = UMUCapabilities.FLUID_TANK_HANDLER_CAPABILITY.writeNBT(this.getCachedTankCistern(), null);

		if (backpackNBT != null) compoundNBT.put("Backpack", backpackNBT);
		if (quiverNBT != null) compoundNBT.put("Quiver", quiverNBT);
		if (tankNBT != null) compoundNBT.put("Tank", tankNBT);

		return compoundNBT;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		INBT backpackNBT = nbt.get("Backpack");
		INBT quiverNBT = nbt.get("Quiver");
		INBT tankNBT = nbt.get("Tank");

		if (backpackNBT != null)
			CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(this.getCachedBackpackInventory(), null, backpackNBT);
		if (quiverNBT != null)
			CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(this.getCachedQuiverInventory(), null, quiverNBT);
		if (tankNBT != null)
			UMUCapabilities.FLUID_TANK_HANDLER_CAPABILITY.readNBT(this.getCachedTankCistern(), null, tankNBT);
	}

	@Nonnull
	public IItemHandler getCachedBackpackInventory() {
		if (this.backpackInventory == null) {
			this.backpackInventory = new ItemStackHandler(36);
		}

		return this.backpackInventory;
	}

	@Nonnull
	public IItemHandler getCachedQuiverInventory() {
		if (this.quiverInventory == null) {
			this.quiverInventory = new ItemStackHandler(9);
		}

		return quiverInventory;
	}

	@Nonnull
	public IFluidTankHandler getCachedTankCistern() {
		if (this.tankCistern == null) {
			this.tankCistern = new FluidTankHandler(4);
		}

		return tankCistern;
	}
}

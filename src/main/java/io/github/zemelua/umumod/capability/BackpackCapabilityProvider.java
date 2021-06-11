package io.github.zemelua.umumod.capability;

import io.github.zemelua.umumod.fluid.FluidTankHandler;
import io.github.zemelua.umumod.fluid.IFluidTankHandler;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BackpackCapabilityProvider implements ICapabilitySerializable<CompoundNBT> {
	private IItemHandler backpackInventory = null;
	private IItemHandler quiverInventory = null;
	private IFluidTankHandler tank;
	private final LazyOptional<IItemHandler> backpackInventorySupplier = LazyOptional.of(this::getCachedBackpackInventory);
	private final LazyOptional<IItemHandler> quiverInventorySupplier = LazyOptional.of(this::getCachedQuiverInventory);
	private final LazyOptional<IFluidTankHandler> tankSupplier = LazyOptional.of(this::getCachedTank);
	private final boolean hasQuiver;
	private final boolean hasTank;

	private BackpackCapabilityProvider(boolean hasQuiver, boolean hasTank) {
		this.hasQuiver = hasQuiver;
		this.hasTank = hasTank;
	}

	public static BackpackCapabilityProvider createBackpackProvider() {
		return new BackpackCapabilityProvider(false, false);
	}

	public static BackpackCapabilityProvider createHuntersBackpackProvider() {
		return new BackpackCapabilityProvider(true, false);
	}

	public static BackpackCapabilityProvider createTankableBackpackProvider() {
		return new BackpackCapabilityProvider(false, true);
	}

	public static BackpackCapabilityProvider createHuntersTankableBackpackProvider() {
		return new BackpackCapabilityProvider(true, true);
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (side != null) {
			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				if (side.getAxis() == Direction.Axis.X) {
					return this.backpackInventorySupplier.cast();
				}
				if (side.getAxis() == Direction.Axis.Y && hasQuiver) {
					return this.quiverInventorySupplier.cast();
				}
			} else if (cap == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
				if (side.getAxis() == Direction.Axis.Z && hasTank) {
					return this.tankSupplier.cast();
				}
			}
		}

		return LazyOptional.empty();
	}

	@SuppressWarnings("ConstantConditions")
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT compoundNBT =  new CompoundNBT();
		INBT backpackNBT = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.writeNBT(this.getCachedBackpackInventory(), null);
		compoundNBT.put("Backpack", backpackNBT);
		if (hasQuiver) {
			INBT quiverNBT = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.writeNBT(this.getCachedQuiverInventory(), null);
			compoundNBT.put("Quiver", quiverNBT);
		}
		if (hasTank) {
			INBT tankNBT = UMUCapabilities.FLUID_TANK_HANDLER_CAPABILITY.writeNBT(this.getCachedTank(), null);
			compoundNBT.put("Tank", tankNBT);
		}

		return compoundNBT;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(this.getCachedBackpackInventory(), null, nbt.get("Backpack"));
		if (this.hasQuiver) {
			CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(this.getCachedQuiverInventory(), null, nbt.get("Quiver"));
		}
		if (this.hasTank) {
			UMUCapabilities.FLUID_TANK_HANDLER_CAPABILITY.readNBT(this.getCachedTank(), null, nbt.get("Tank"));
		}
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

		return this.quiverInventory;
	}

	@Nonnull
	public IFluidTankHandler getCachedTank() {
		if (this.tank == null) {
			this.tank = new FluidTankHandler(4);
		}

		return this.tank;
	}
}

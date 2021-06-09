package io.github.zemelua.umumod.capability;

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

public class BackpackCapabilityProvider implements ICapabilitySerializable<INBT> {
	private IItemHandler backpackInventory = null;
	private IItemHandler quiverInventory = null;
	private final LazyOptional<IItemHandler> backpackInventorySupplier = LazyOptional.of(this::getCachedBackpackInventory);
	private final LazyOptional<IItemHandler> quiverInventorySupplier = LazyOptional.of(this::getCachedQuiverInventory);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && side != null) {
			if (side.getAxis().isHorizontal()) return this.backpackInventorySupplier.cast();
			if (side.getAxis().isVertical()) return this.quiverInventorySupplier.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public INBT serializeNBT() {
		// return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.writeNBT(this.getCachedBackpackInventory(), null);
		// What should I do here?
		return null;
	}

	@Override
	public void deserializeNBT(INBT nbt) {
		// CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(this.getCachedBackpackInventory(), null, nbt);
		// What should I do here?
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
}

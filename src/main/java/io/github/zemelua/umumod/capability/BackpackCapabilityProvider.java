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
	private IItemHandler inventory = null;
	private final LazyOptional<IItemHandler> inventorySupplier = LazyOptional.of(this::getCachedInventory);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return this.inventorySupplier.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public INBT serializeNBT() {
		return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.writeNBT(this.getCachedInventory(), null);
	}

	@Override
	public void deserializeNBT(INBT nbt) {
		CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(this.getCachedInventory(), null, nbt);
	}

	@Nonnull
	public IItemHandler getCachedInventory() {
		if (this.inventory == null) {
			this.inventory = new ItemStackHandler(36);
		}

		return this.inventory;
	}
}

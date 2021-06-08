package io.github.zemelua.umumod.capability;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BackpackCapabilityProvider implements ICachedCapabilitySerializable<IItemHandler, INBT> {
	private IItemHandler inventory = null;
	private final LazyOptional<IItemHandler> inventorySupplier = LazyOptional.of(this::getCachedContents);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, inventorySupplier);
	}

	@Override
	public INBT serializeNBT() {
		return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.writeNBT(inventory, null);
	}

	@Override
	public void deserializeNBT(INBT nbt) {
		CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(inventory, null, nbt);
	}

	@Nonnull
	@Override
	public IItemHandler getCachedContents() {
		if (inventory == null) {
			this.inventory = new ItemStackHandler(36);
		}
		return inventory;
	}
}

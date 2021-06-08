package io.github.zemelua.umumod.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public abstract class AbstractUMUPlayerContainer extends Container {
	protected final PlayerEntity player;

	protected AbstractUMUPlayerContainer(ContainerType<?> type, int id, PlayerInventory playerInventory, PlayerEntity player) {
		super(type, id);

		this.player = player;

		//index : 9 - 35
		for(int iV = 0; iV < 3; iV++) {
			for(int iU = 0; iU < 9; iU++) {
				this.addSlot(new Slot(playerInventory, iU + (iV + 1) * 9, 186 + iU * 18, 104 + iV * 18));
			}
		}
		for(int i = 0; i < 9; i++) {
			this.addSlot(new Slot(playerInventory, i, 186 + i * 18, 162));
		}
	}

	@Override
	@SuppressWarnings("NullableProblems")
	public boolean canInteractWith(PlayerEntity playerIn) {
		return true;
	}

	@Override
	@SuppressWarnings({"ConstantConditions", "NullableProblems"})
	public final ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		Slot slot = this.inventorySlots.get(index);
		ItemStack returnStack = ItemStack.EMPTY;

		if (slot == null || !slot.getHasStack()) return returnStack;

		ItemStack currentStack = slot.getStack();
		returnStack = currentStack.copy();

		if (index >= 0 && index < 27) {
			if (!this.mergeItemStack(currentStack, 27, 36, false)) {
				return ItemStack.EMPTY;
			}
		} else if (index >= 27 && index < 36) {
			if (!this.mergeItemStack(currentStack, 0, 27, false)) {
				return ItemStack.EMPTY;
			}
		} else {
			if (!this.mergeItemStack(currentStack, 0, 36, false)) {
				return ItemStack.EMPTY;
			}
		}

		if (currentStack.isEmpty()) {
			slot.putStack(ItemStack.EMPTY);
		} else {
			slot.onSlotChanged();
		}

		if (currentStack.getCount() == returnStack.getCount()) {
			return ItemStack.EMPTY;
		}

		return returnStack;
	}
}

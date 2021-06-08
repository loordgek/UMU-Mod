package io.github.zemelua.umumod.inventory.container.slot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public abstract class DynamicInventoryItemHandlerSlot extends Slot {
	private final static IInventory EMPTY = new Inventory(0);
	protected IItemHandler itemHandler;

	public DynamicInventoryItemHandlerSlot(IItemHandler inventoryIn, int index, int xPosition, int yPosition) {
		super(EMPTY, index, xPosition, yPosition);
		this.itemHandler = inventoryIn;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if (stack.isEmpty())
			return false;
		return itemHandler.isItemValid(this.getSlotIndex(), stack);
	}

	@Override
	public ItemStack getStack() {
		return this.itemHandler.getStackInSlot(this.getSlotIndex());
	}

	@Override
	public void putStack(ItemStack stack) {
		((IItemHandlerModifiable) this.itemHandler).setStackInSlot(this.getSlotIndex(), stack);
		this.onSlotChanged();
	}

	@Override
	public void onSlotChanged() {
	}

	@Override
	public int getSlotStackLimit() {
		return this.itemHandler.getSlotLimit(this.getSlotIndex());
	}

	@Override
	public int getItemStackLimit(ItemStack stack) {
		ItemStack maxAdd = stack.copy();
		int maxInput = stack.getMaxStackSize();
		maxAdd.setCount(maxInput);

		IItemHandler handler = this.itemHandler;
		int index = this.getSlotIndex();
		ItemStack currentStack = handler.getStackInSlot(index);
		if (handler instanceof IItemHandlerModifiable) {
			IItemHandlerModifiable handlerModifiable = (IItemHandlerModifiable) handler;

			handlerModifiable.setStackInSlot(index, ItemStack.EMPTY);

			ItemStack remainder = handlerModifiable.insertItem(index, maxAdd, true);

			handlerModifiable.setStackInSlot(index, currentStack);

			return maxInput - remainder.getCount();
		}
		else
		{
			ItemStack remainder = handler.insertItem(index, maxAdd, true);

			int current = currentStack.getCount();
			int added = maxInput - remainder.getCount();
			return current + added;
		}
	}

	@Override
	public ItemStack decrStackSize(int amount) {
		return this.itemHandler.extractItem(this.getSlotIndex(), amount, false);
	}

	@Override
	public boolean canTakeStack(PlayerEntity playerIn) {
		return !this.itemHandler.extractItem(this.getSlotIndex(), 1, true).isEmpty();
	}

	protected abstract void upDateInventory();
}

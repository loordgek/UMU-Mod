package io.github.zemelua.umumod.util;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public final class ItemStackUtil {
	private ItemStackUtil() {
		throw new AssertionError();
	}

	public static boolean canCombine(ItemStack stack1, ItemStack stack2) {
		if (stack1.getItem() != stack2.getItem()) {
			return false;
		} else if (stack1.getDamage() != stack2.getDamage()) {
			return false;
		} else if (stack1.getCount() > stack1.getMaxStackSize()) {
			return false;
		} else {
			return ItemStack.areItemStackTagsEqual(stack1, stack2);
		}
	}

	public static Inventory createInventoryFromItemHandler(IItemHandler itemHandler) {
		ItemStack[] itemStacks = new ItemStack[itemHandler.getSlots()];
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			itemStacks[i] = itemHandler.getStackInSlot(i);
		}
		return new Inventory(itemStacks);
	}
}

package io.github.zemelua.umumod.inventory.container;

import net.minecraft.item.ItemStack;

public interface IUpdateInventoryElement {
	void updateInventory(int slotIndex, ItemStack itemStack);
}

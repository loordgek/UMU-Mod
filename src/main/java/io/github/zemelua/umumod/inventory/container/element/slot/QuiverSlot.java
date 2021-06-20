package io.github.zemelua.umumod.inventory.container.element.slot;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

public class QuiverSlot extends AbstractBelongingsSlot {
	public QuiverSlot(IItemHandler baseItemHandler, IItemHandler inventoryItemHandler, int index, int xPosition, int yPosition) {
		super(baseItemHandler, inventoryItemHandler, index, xPosition, yPosition);
	}

	@Override
	public void updateInventory(int slotIndex, ItemStack itemStack) {

	}
}

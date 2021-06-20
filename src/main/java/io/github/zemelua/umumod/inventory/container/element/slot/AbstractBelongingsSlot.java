package io.github.zemelua.umumod.inventory.container.element.slot;

import io.github.zemelua.umumod.inventory.container.IUpdateInventoryElement;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public abstract class AbstractBelongingsSlot extends SlotItemHandler implements IUpdateInventoryElement {
	protected IItemHandler inventoryItemHandler;

	public AbstractBelongingsSlot(IItemHandler baseItemHandler, IItemHandler inventoryItemHandler, int index, int xPosition, int yPosition) {
		super(baseItemHandler, index, xPosition, yPosition);
		this.inventoryItemHandler = inventoryItemHandler;
	}

	@Override
	public IItemHandler getItemHandler() {
		return this.inventoryItemHandler;
	}
}

package io.github.zemelua.umumod.inventory.container.slot;

import io.github.zemelua.umumod.item.UMUItems;
import io.github.zemelua.umumod.util.UMUEntityUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class BackpackSlot extends AbstractBelongingsSlot {
	private final PlayerEntity player;
	private final int size;

	public BackpackSlot(IItemHandler baseItemHandler, IItemHandler inventoryItemHandler, int index, int xPosition, int yPosition, PlayerEntity player, int size) {
		super(baseItemHandler, inventoryItemHandler, index, xPosition, yPosition);
		this.player = player;
		this.size = size;
	}

	@Override
	public boolean isEnabled() {
		if (UMUEntityUtil.hasBackpack(player)) {
			return UMUEntityUtil.getBackpackSize(Minecraft.getInstance().player) >= size;
		}

		return false;
	}

	@Override
	public void updateInventory(int slotIndex, ItemStack itemStack) {
		if (slotIndex != 37) return;
		if (itemStack.getItem() == UMUItems.BACKPACK.get()) {
			this.inventoryItemHandler = itemStack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
					.orElse(new ItemStackHandler(36));
		} else {
			this.inventoryItemHandler = new ItemStackHandler(36);
		}
	}
}

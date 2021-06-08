package io.github.zemelua.umumod.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;

public class BackpackContainer extends PlayerContainer {
	private final PlayerEntity player;

	protected BackpackContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {
		this(id, playerInventory.player);
	}

	public BackpackContainer(int id, PlayerEntity player) {
		super(player.inventory, !player.getEntityWorld().isRemote(), player);

		this.player = player;

		for (int i = 0; i < this.inventorySlots.size(); i ++) {
			if (inventorySlots.get(i).inventory == player.inventory && i < player.inventory.getSizeInventory() - 5) {
				inventorySlots.set(i, new Slot(inventorySlots.get(i).inventory, inventorySlots.get(i).getSlotIndex(), inventorySlots.get(i).xPos, inventorySlots.get(i).yPos + 58));
			}
		}
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return false;
	}
}

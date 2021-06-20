package io.github.zemelua.umumod.inventory.container;

import io.github.zemelua.umumod.capability.UMUCapabilities;
import io.github.zemelua.umumod.fluid.FluidTankHandler;
import io.github.zemelua.umumod.inventory.UMUEquipmentSlotType;
import io.github.zemelua.umumod.inventory.container.element.slot.AbstractBelongingsSlot;
import io.github.zemelua.umumod.inventory.container.element.slot.BackpackSlot;
import io.github.zemelua.umumod.inventory.container.element.slot.EquipmentSlot;
import io.github.zemelua.umumod.inventory.container.element.slot.OffhandSlot;
import io.github.zemelua.umumod.inventory.container.element.tank.Tank;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class BelongingsUMUPlayerContainer extends AbstractUMUPlayerContainer {
	private NonNullList<ItemStack> inventoryItemStacks = NonNullList.create();

	private static final UMUEquipmentSlotType[] VALID_EQUIPMENT_SLOTS = new UMUEquipmentSlotType[]{
			UMUEquipmentSlotType.HEAD, UMUEquipmentSlotType.CHEST, UMUEquipmentSlotType.LEGS, UMUEquipmentSlotType.FEET
	};
	private static final UMUEquipmentSlotType[] VALID_RING_SLOTS = new UMUEquipmentSlotType[]{
			UMUEquipmentSlotType.MAINRING1, UMUEquipmentSlotType.MAINRING2, UMUEquipmentSlotType.OFFRING1, UMUEquipmentSlotType.OFFRING2
	};
	private static final UMUEquipmentSlotType[] VALID_MISCELLANEOUS_SLOTS = new UMUEquipmentSlotType[]{
			UMUEquipmentSlotType.ENCYCLOPEDIA, UMUEquipmentSlotType.MAP
	};

	public BelongingsUMUPlayerContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {
		this(UMUContainers.BELONGING_INVENTORY.get(), id, playerInventory, playerInventory.player);
	}

	public BelongingsUMUPlayerContainer(ContainerType<?> type, int id, PlayerInventory playerInventory, PlayerEntity player) {
		super(type, id, playerInventory, player);

		// index : 36 - 39
		for (int i = 0; i < 4; i++) {
			this.addSlot(new EquipmentSlot(playerInventory, 39 - i, 186, 18 + i * 18, VALID_EQUIPMENT_SLOTS[i]));
		}
		this.addSlot(new OffhandSlot(playerInventory, 40, 255, 72));
		this.addSlot(new EquipmentSlot(playerInventory, 41, 293, 27, UMUEquipmentSlotType.NECKLACE));
		// index : 42 - 45
		for (int iU = 0; iU < 2; iU++) {
			for (int iV = 0; iV < 2; iV++) {
				this.addSlot(new EquipmentSlot(playerInventory, 42 + iU * 2 + iV, 282 + iU * 18 + 4, 48 + iV * 18, VALID_RING_SLOTS[iU * 2 + iV]));
			}
		}
		for (int i = 0; i < 2; i++) {
			this.addSlot(new EquipmentSlot(playerInventory, 46 + i, 330, 72 + i * 18, VALID_MISCELLANEOUS_SLOTS[i]));
		}
		for (int iV = 0; iV < 4; iV++) {
			for (int iU = 0; iU < 9; iU++) {
				this.addSlot(new BackpackSlot(
						new ItemStackHandler(36),
						this.player.getItemStackFromSlot(EquipmentSlotType.CHEST).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(new ItemStackHandler(36)),
						iU + iV * 9, 8 + iU * 18, 18 + iV * 18, player, iV + 1
				));
			}
		}
		for (int i = 0; i < 9; i++) {

		}

		this.addTank(new Tank(
				0, this.player.getItemStackFromSlot(EquipmentSlotType.CHEST).getCapability(UMUCapabilities.FLUID_TANK_HANDLER_CAPABILITY).orElse(new FluidTankHandler(4)),
				134, 158
		));
	}

	@Override
	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, PlayerEntity player) {
		this.inventorySlots.subList(48, 83).stream()
				.filter(s -> s instanceof AbstractBelongingsSlot)
				.forEach(s -> ((AbstractBelongingsSlot) s)
						.updateInventory(slotId, player.inventory.getItemStack()));

		// Synchronize backpack inventory to client ?

		return super.slotClick(slotId, dragType, clickTypeIn, player);
	}
}

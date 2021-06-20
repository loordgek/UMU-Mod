package io.github.zemelua.umumod.util;

import io.github.zemelua.umumod.fluid.IFluidTankHandler;
import io.github.zemelua.umumod.inventory.UMUEquipmentSlotType;
import io.github.zemelua.umumod.item.UMUItems;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.items.IItemHandler;

public class UMUEntityUtil {
	public static UMUEquipmentSlotType getSlotForItemStack(ItemStack itemStack) {
		EquipmentSlotType vanillaType = itemStack.getEquipmentSlot();
		if (vanillaType != null) return UMUEquipmentSlotType.fromVanillaSlotType(vanillaType);
		Item item = itemStack.getItem();
		if (item != Blocks.CARVED_PUMPKIN.asItem() && (!(item instanceof BlockItem) || !(((BlockItem)item).getBlock() instanceof AbstractSkullBlock))) {
			if (item instanceof ArmorItem) {
				vanillaType = ((ArmorItem) item).getEquipmentSlot();
			} else if (item == Items.ELYTRA) {
				vanillaType = EquipmentSlotType.CHEST;
			} else if (item == Items.SHIELD) {
				vanillaType = EquipmentSlotType.OFFHAND;
			} else {
				vanillaType = EquipmentSlotType.MAINHAND;
			}
		} else {
			vanillaType = EquipmentSlotType.HEAD;
		}

		return UMUEquipmentSlotType.fromVanillaSlotType(vanillaType);
	}

	public static boolean hasBackpack(LivingEntity entity) {
		ItemStack backpack = entity.getItemStackFromSlot(EquipmentSlotType.CHEST);

		return (backpack.getItem() == UMUItems.BACKPACK.get() || backpack.getItem() == UMUItems.FUNCTIONAL_BACKPACK.get());
	}

	public static boolean hasQuiver(LivingEntity entity) {
		ItemStack quiver = entity.getItemStackFromSlot(EquipmentSlotType.CHEST);

		return (quiver.getItem() == UMUItems.QUIVER.get() || quiver.getItem() == UMUItems.FUNCTIONAL_BACKPACK.get());
	}

	public static boolean hasTank(LivingEntity entity) {
		ItemStack tank = entity.getItemStackFromSlot(EquipmentSlotType.CHEST);

		return (tank.getItem() == UMUItems.TANK.get() || tank.getItem() == UMUItems.FUNCTIONAL_BACKPACK.get());
	}

	public static IItemHandler getBackpackInventory(LivingEntity living) {
		return UMUItemUtil.getBackpackInventory(living.getItemStackFromSlot(EquipmentSlotType.CHEST));
	}

	public static IItemHandler getQuiverInventory(LivingEntity living) {
		return UMUItemUtil.getQuiverInventory(living.getItemStackFromSlot(EquipmentSlotType.CHEST));
	}

	public static IFluidTankHandler getTankInventory(LivingEntity living) {
		return UMUItemUtil.getTankCistern(living.getItemStackFromSlot(EquipmentSlotType.CHEST));
	}

	public static int getBackpackSize(LivingEntity living) {
		return UMUItemUtil.getBackpackSize(living.getItemStackFromSlot(EquipmentSlotType.CHEST));
	}
}

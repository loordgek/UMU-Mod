package io.github.zemelua.umumod.util;

import io.github.zemelua.umumod.inventory.UMUEquipmentSlotType;
import io.github.zemelua.umumod.item.UMUItems;
import net.minecraft.block.AbstractSkullBlock;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;

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



	@SuppressWarnings("RedundantIfStatement")
	public static boolean hasBackpack(LivingEntity entity) {
		if (entity.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == UMUItems.BACKPACK.get()) {
			return true;
		}

		return false;
	}

	public static int getBackpackSize(LivingEntity entity) {
		return 3;
		/*
		if (hasBackpack(entity)) {
			entity.getItemStackFromSlot(EquipmentSlotType.CHEST).getEnchantmentTagList();
		}
		 */
	}

	public static boolean hasQuiver(LivingEntity entity) {
		return false;
	}

	public static boolean hasToolbelt(LivingEntity entity) {
		return false;
	}
}

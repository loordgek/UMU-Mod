package io.github.zemelua.umumod.inventory.container.element.slot;

import com.mojang.datafixers.util.Pair;
import io.github.zemelua.umumod.inventory.UMUEquipmentSlotType;
import io.github.zemelua.umumod.util.UMUEntityUtil;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class EquipmentSlot extends Slot {
	public static final ResourceLocation EMPTY_ARMOR_SLOT_NECKLACE = new ResourceLocation("item/empty_armor_slot_necklace");
	public static final ResourceLocation EMPTY_ARMOR_SLOT_RING = new ResourceLocation("item/empty_armor_slot_ring");
	public static final ResourceLocation EMPTY_ARMOR_SLOT_ENCYCLOPEDIA = new ResourceLocation("item/empty_armor_slot_encyclopedia");
	public static final ResourceLocation EMPTY_ARMOR_SLOT_MAP = new ResourceLocation("item/empty_armor_slot_map");
	private static final ResourceLocation[] ARMOR_SLOT_TEXTURES = new ResourceLocation[] {
			PlayerContainer.EMPTY_ARMOR_SLOT_BOOTS, PlayerContainer.EMPTY_ARMOR_SLOT_LEGGINGS,
			PlayerContainer.EMPTY_ARMOR_SLOT_CHESTPLATE, PlayerContainer.EMPTY_ARMOR_SLOT_HELMET
	};
	private static final ResourceLocation[] ACCESSORY_SLOT_TEXTURES = new ResourceLocation[] {
			EMPTY_ARMOR_SLOT_NECKLACE, EMPTY_ARMOR_SLOT_RING, EMPTY_ARMOR_SLOT_RING, EMPTY_ARMOR_SLOT_RING,
			EMPTY_ARMOR_SLOT_RING
	};
	private static final ResourceLocation[] MISCELLANEOUS_SLOT_TEXTURES = new ResourceLocation[] {
			EMPTY_ARMOR_SLOT_ENCYCLOPEDIA, EMPTY_ARMOR_SLOT_MAP
	};

	private final UMUEquipmentSlotType equipmentType;

	public EquipmentSlot(IInventory inventoryIn, int index, int xPosition, int yPosition, UMUEquipmentSlotType equipmentType) {
		super(inventoryIn, index, xPosition, yPosition);

		if (equipmentType == UMUEquipmentSlotType.MAINHAND || equipmentType == UMUEquipmentSlotType.OFFHAND) {
			throw new IllegalArgumentException("Invalid type" + equipmentType);
		}
		this.equipmentType = equipmentType;
	}

	@Override
	public int getSlotStackLimit() {
		return 1;
	}

	@Override
	@SuppressWarnings("NullableProblems")
	public boolean isItemValid(ItemStack stack) {
		return UMUEntityUtil.getSlotForItemStack(stack) == this.equipmentType;
	}

	@Override
	@SuppressWarnings("NullableProblems")
	public boolean canTakeStack(PlayerEntity player) {
		ItemStack itemstack = this.getStack();
		return (itemstack.isEmpty() || player.isCreative() || !EnchantmentHelper.hasBindingCurse(itemstack)) && super.canTakeStack(player);
	}

	@Nullable
	@Override
	public Pair<ResourceLocation, ResourceLocation> getBackground() {
		ResourceLocation mark;
		if (this.equipmentType.getGroup() == UMUEquipmentSlotType.Group.ARMOR) {
			mark = ARMOR_SLOT_TEXTURES[this.equipmentType.getIndex()];
		} else if (this.equipmentType.getGroup() == UMUEquipmentSlotType.Group.ACCESSORY) {
			mark = ACCESSORY_SLOT_TEXTURES[this.equipmentType.getIndex()];
		} else {
			mark = MISCELLANEOUS_SLOT_TEXTURES[this.equipmentType.getIndex()];
		}
		return Pair.of(PlayerContainer.LOCATION_BLOCKS_TEXTURE, mark);
	}
}

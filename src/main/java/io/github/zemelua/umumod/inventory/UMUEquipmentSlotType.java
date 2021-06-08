package io.github.zemelua.umumod.inventory;

import net.minecraft.inventory.EquipmentSlotType;

import javax.annotation.Nullable;

public enum UMUEquipmentSlotType {
	MAINHAND    (Group.HAND,          EquipmentSlotType.MAINHAND, 0, 0,  "mainhand"),
	OFFHAND     (Group.HAND,          EquipmentSlotType.OFFHAND,  1, 5,  "offhand"),
	FEET        (Group.ARMOR,         EquipmentSlotType.FEET,     0, 1,  "feet"),
	LEGS        (Group.ARMOR,         EquipmentSlotType.LEGS,     1, 2,  "legs"),
	CHEST       (Group.ARMOR,         EquipmentSlotType.CHEST,    2, 3,  "chest"),
	HEAD        (Group.ARMOR,         EquipmentSlotType.HEAD,     3, 4,  "head"),
	NECKLACE    (Group.ACCESSORY,     null,                       0, 6,  "necklace"),
	MAINRING1   (Group.ACCESSORY,     null,                       1, 7,  "mainring1"),
	MAINRING2   (Group.ACCESSORY,     null,                       2, 8,  "mainring2"),
	OFFRING1    (Group.ACCESSORY,     null,                       3, 9,  "offring1"),
	OFFRING2    (Group.ACCESSORY,     null,                       4, 10, "offring2"),
	ENCYCLOPEDIA(Group.MISCELLANEOUS, null,                       0, 11, "encyclopedia"),
	MAP         (Group.MISCELLANEOUS, null,                       1, 12, "map")
	;

	private final Group group;
	@Nullable private final EquipmentSlotType vanillaType;
	private final int index;
	private final int slotIndex;
	private final String name;

	UMUEquipmentSlotType(Group group, EquipmentSlotType vanillaType, int index, int slotIndex, String name) {
		this.group = group;
		this.vanillaType = vanillaType;
		this.index = index;
		this.slotIndex = slotIndex;
		this.name = name;
	}

	public Group getGroup() {
		return this.group;
	}

	public int getIndex() {
		return this.index;
	}

	public int getSlotIndex() {
		return this.slotIndex;
	}

	public String getName() {
		return this.name;
	}

	public EquipmentSlotType getVanillaType() {
		return this.vanillaType;
	}

	public static UMUEquipmentSlotType fromString(String name) {
		for(UMUEquipmentSlotType slotType : values()) {
			if (slotType.getName().equals(name)) {
				return slotType;
			}
		}

		throw new IllegalArgumentException("Invalid slot '" + name + "'");
	}

	public static UMUEquipmentSlotType fromSlotTypeAndIndex(Group group, int index) {
		for(UMUEquipmentSlotType slotType : values()) {
			if (slotType.getGroup() == group && slotType.getIndex() == index) {
				return slotType;
			}
		}

		throw new IllegalArgumentException("Invalid slot '" + group + "': " + index);
	}

	public static UMUEquipmentSlotType fromVanillaSlotType(EquipmentSlotType vanillaType) {
		for (UMUEquipmentSlotType slotType : values()) {
			if (slotType.getVanillaType() == null) break;
			if (slotType.getVanillaType() == vanillaType) {
				return slotType;
			}
		}

		throw new IllegalArgumentException("Invalid slot '" + vanillaType + "'");
	}

	public enum Group {
		HAND,
		ARMOR,
		ACCESSORY,
		MISCELLANEOUS
	}
}

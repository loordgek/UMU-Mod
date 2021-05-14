package io.github.zemelua.umumod.block.blockstateproperty;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.IStringSerializable;

import java.util.function.Supplier;

public enum WoodenBoxContents implements IStringSerializable {
	EMPTY("empty", Items.AIR.delegate),
	APPLE("apple", Items.APPLE.delegate),
	COD  ("cod",   Items.COD.delegate);

	private final String name;
	private final Supplier<Item> item;

	WoodenBoxContents(String name, Supplier<Item> item) {
		this.name = name;
		this.item = item;
	}

	public Item getItem() {
		return item.get();
	}

	@Override
	public String toString() {
		return getString();
	}

	@SuppressWarnings("NullableProblems")
	@Override
	public String getString() {
		return name;
	}

	public static boolean isValidItem(Item item) {
		for (WoodenBoxContents contents : WoodenBoxContents.values()) {
			if (contents != EMPTY && contents.getItem().equals(item)) {
				return true;
			}
		}

		return false;
	}

	public static WoodenBoxContents getByItem(Item item) {
		for (WoodenBoxContents contents : WoodenBoxContents.values()) {
			if (contents.getItem().equals(item)) {
				return contents;
			}
		}

		return EMPTY;
	}
}

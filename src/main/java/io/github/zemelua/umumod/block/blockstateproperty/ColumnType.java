package io.github.zemelua.umumod.block.blockstateproperty;

import net.minecraft.util.IStringSerializable;

public enum ColumnType implements IStringSerializable {
	TOP("top"),
	MIDDLE("middle"),
	BOTTOM("bottom");

	private final String typeName;

	private ColumnType(String name) {
		this.typeName = name;
	}

	@Override
	public String toString() {
		return this.getString();
	}

	@Override
	public String getString() {
		return this.typeName;
	}
}

package io.github.zemelua.umumod.block.blockstateproperty;

import net.minecraft.util.IStringSerializable;

public enum VerticalSlabType implements IStringSerializable {
	NORTH("north"),
	SOUTH("south"),
	WEST("west"),
	EAST("east"),
	DOUBLE("double");

	private final String name;

	private VerticalSlabType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getString();
	}

	@Override
	public String getString() {
		return this.name;
	}
}

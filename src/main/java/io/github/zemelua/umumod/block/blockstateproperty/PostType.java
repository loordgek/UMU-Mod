package io.github.zemelua.umumod.block.blockstateproperty;

import net.minecraft.util.IStringSerializable;

public enum PostType implements IStringSerializable {
	NORTH     ("north"),
	NORTH_WEST("north_west"),
	WEST      ("west"),
	WEST_SOUTH("south"),
	SOUTH     ("south"),
	SOUTH_EAST("east"),
	EAST      ("east"),
	EAST_NORTH("east_north"),
	CENTER    ("center")
	;

	private final String name;

	PostType(String name) {
		this.name = name;
	}

	@Override
	public String getString() {
		return this.name;
	}


	@Override
	public String toString() {
		return this.getString();
	}
}

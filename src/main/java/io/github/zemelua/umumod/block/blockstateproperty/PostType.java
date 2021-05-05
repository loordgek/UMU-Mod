package io.github.zemelua.umumod.block.blockstateproperty;

import net.minecraft.util.IStringSerializable;

public enum PostType implements IStringSerializable {
	NORTH     ("north",      3),
	NORTH_WEST("north_west", 0),
	WEST      ("west",       1),
	WEST_SOUTH("west_south", 2),
	SOUTH     ("south",      5),
	SOUTH_EAST("south_east", 8),
	EAST      ("east",       7),
	EAST_NORTH("east_north", 6),
	CENTER    ("center",     4)
	;

	private final String name;
	private final int index;

	PostType(String name, int index) {
		this.name = name;
		this.index = index;
	}

	@SuppressWarnings("NullableProblems")
	@Override
	public String getString() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.getString();
	}

	public static PostType getByIndex(int index) {
		for (PostType postType : PostType.values()) {
			if (postType.index == index) return postType;
		}
		return PostType.NORTH;
	}
}

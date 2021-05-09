package io.github.zemelua.umumod.util.math;

import java.util.Objects;

public class Vector2i {
	public static final Vector2i ZERO = new Vector2i(0, 0);
	public static final Vector2i ONE = new Vector2i(1, 1);
	public static final Vector2i UNIT_X = new Vector2i(1, 0);
	public static final Vector2i NEGATIVE_UNIT_X = new Vector2i(-1, 0);
	public static final Vector2i UNIT_Y = new Vector2i(0, 1);
	public static final Vector2i NEGATIVE_UNIT_Y = new Vector2i(0, -1);
	public static final Vector2i MAX = new Vector2i(Integer.MAX_VALUE, Integer.MAX_VALUE);
	public static final Vector2i MIN = new Vector2i(Integer.MIN_VALUE, Integer.MIN_VALUE);
	public int x;
	public int y;

	public Vector2i(int xIn, int yIn) {
		this.x = xIn;
		this.y = yIn;
	}

	public Vector2i subtract(int x, int y) {
		this.x -= x;
		this.y -= y;
		return this;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Vector2i) {
			Vector2i other = (Vector2i) object;
			return this.x == other.x && this.y == other.y;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}

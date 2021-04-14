package io.github.zemelua.umumod.client.renderer.model.connection;

import javax.annotation.Nullable;

public class FlexibleContext {
	public static final FlexibleContext[] VERTICAL = new FlexibleContext[] {
		makeShapeVertical(),
		makeShapeVertical(0), makeShapeVertical(1),
		makeShapeVertical(0, 1)
	};

	public static final FlexibleContext[] HORIZONTAL = new FlexibleContext[] {
		makeShapeHorizontal(),
		makeShapeHorizontal(0), makeShapeHorizontal(1),
		makeShapeHorizontal(0, 1)
	};

	public static final FlexibleContext[] CROSS = new FlexibleContext[] {
		makeShapeCross(),
		makeShapeCross(0),       makeShapeCross(1),       makeShapeCross(2),       makeShapeFull(3),
		makeShapeCross(0, 1),    makeShapeCross(0, 2),    makeShapeCross(0, 3),    makeShapeCross(1, 2),
		makeShapeCross(1, 3),    makeShapeCross(2, 3),    makeShapeCross(0, 1, 2), makeShapeCross(0, 1, 3),
		makeShapeCross(0, 2, 3), makeShapeCross(1, 2, 3),
		makeShapeCross(0, 1, 2, 3)
	};

	public static final FlexibleContext[] FULL = new FlexibleContext[] {
		makeShapeFull(),
		makeShapeFull(0),          makeShapeFull(2),          makeShapeFull(4),          makeShapeFull(6),
		makeShapeFull(0, 2),       makeShapeFull(0, 4),       makeShapeFull(0, 6),       makeShapeFull(2, 4),
		makeShapeFull(2, 6),       makeShapeFull(4, 6),       makeShapeFull(0, 1, 2),    makeShapeFull(0, 2, 4),
		makeShapeFull(0, 2, 6),    makeShapeFull(0, 4, 6),    makeShapeFull(0, 6, 7),    makeShapeFull(2, 3, 4),
		makeShapeFull(2, 4, 6),    makeShapeFull(4, 5, 6),    makeShapeFull(0, 1, 2, 4), makeShapeFull(0, 1, 2, 6),
		makeShapeFull(0, 2, 3, 4), makeShapeFull(0, 2, 4, 6), makeShapeFull(0, 2, 6, 7), makeShapeFull(0, 4, 5, 6),
		makeShapeFull(0, 4, 6, 7), makeShapeFull(2, 3, 4, 6), makeShapeFull(2, 4, 5, 6),
		makeShapeFull(0, 1, 2, 3, 4),       makeShapeFull(0, 1, 2, 4, 6),       makeShapeFull(0, 1, 2, 6, 7),
		makeShapeFull(0, 2, 3, 4, 6),       makeShapeFull(0, 2, 4, 5, 6),       makeShapeFull(0, 2, 4, 6, 7),
		makeShapeFull(0, 4, 5, 6, 7),       makeShapeFull(2, 3, 4, 5, 6),       makeShapeFull(0, 1, 2, 3, 4, 6),
		makeShapeFull(0, 1, 2, 4, 5, 6),    makeShapeFull(0, 1, 2, 4, 6, 7),    makeShapeFull(0, 2, 3, 4, 5, 6),
		makeShapeFull(0, 2, 3, 4, 6, 7),    makeShapeFull(0, 2, 4, 5, 6, 7),    makeShapeFull(0, 1, 2, 3, 4, 5, 6),
		makeShapeFull(0, 1, 2, 3, 4, 6, 7), makeShapeFull(0, 1, 2, 4, 5, 6, 7), makeShapeFull(0, 2, 3, 4, 5, 6, 7),
		makeShapeFull(0, 1, 2, 3, 4, 5, 6, 7)
	};

	@Nullable
	private final Boolean up;
	@Nullable private final Boolean up_right;
	@Nullable private final Boolean right;
	@Nullable private final Boolean right_down;
	@Nullable private final Boolean down;
	@Nullable private final Boolean down_left;
	@Nullable private final Boolean left;
	@Nullable private final Boolean left_up;

	private FlexibleContext(Boolean up, Boolean up_right, Boolean right, Boolean right_down, Boolean down, Boolean down_left, Boolean left, Boolean left_up) {
		this.up = up;
		this.up_right = up_right;
		this.right = right;
		this.right_down = right_down;
		this.down = down;
		this.down_left = down_left;
		this.left = left;
		this.left_up = left_up;
	}

	public boolean isSameContext(boolean up, boolean up_right, boolean right, boolean right_down, boolean down, boolean down_left, boolean left, boolean left_up) {
		if (this.up != null)         if (this.up.booleanValue() != up)                 return false;
		if (this.up_right != null)   if (this.up_right.booleanValue() != up_right)     return false;
		if (this.right != null)      if (this.right.booleanValue() != right)           return false;
		if (this.right_down != null) if (this.right_down.booleanValue() != right_down) return false;
		if (this.down != null)       if (this.down.booleanValue() != down)             return false;
		if (this.down_left != null)  if (this.down_left.booleanValue() != down_left)   return false;
		if (this.left != null)       if (this.left.booleanValue() != left)             return false;
		if (this.left_up != null)    if (this.left_up.booleanValue() != left_up)       return false;
		return true;
	}

	public boolean isSameContext(boolean[] canConnects) {
		if (canConnects.length == 8) {
			return isSameContext(canConnects[0], canConnects[1], canConnects[2], canConnects[3], canConnects[4], canConnects[5], canConnects[6], canConnects[7]);
		}
		return false;
	}

	private static FlexibleContext makeShapeVertical(int... mergeTo) {
		Boolean[] shape = new Boolean[] { false, null, null, null, false, null, null, null };
		for (int index : mergeTo) {
			shape[index * 4] = true;
		}
		return new FlexibleContext(shape[0], shape[1], shape[2], shape[3], shape[4], shape[5], shape[6], shape[7]);
	}

	private static FlexibleContext makeShapeHorizontal(int... mergeTo) {
		Boolean[] shape = new Boolean[] { null, null, false, null, null, null, false, null };
		for (int index : mergeTo) {
			shape[index * 4 + 2] = true;
		}
		return new FlexibleContext(shape[0], shape[1], shape[2], shape[3], shape[4], shape[5], shape[6], shape[7]);
	}

	private static FlexibleContext makeShapeCross(int... mergeTo) {
		Boolean[] shape = new Boolean[] { false, null, false, null, false, null, false, null };
		for (int index : mergeTo) {
			shape[index * 2] = true;
		}
		return new FlexibleContext(shape[0], shape[1], shape[2], shape[3], shape[4], shape[5], shape[6], shape[7]);
	}

	private static FlexibleContext makeShapeFull(int... mergeTo) {
		Boolean[] shape = new Boolean[] { false, null, false, null, false, null, false, null };
		for (int index : mergeTo) {
			shape[index] = true;
		}
		for (int i = 1; i < 8; i = i + 2) {
			if (shape[i] == null && shape[i + 1 == 8 ? 0 : i + 1] && shape[i - 1]) {
				shape[i] = false;
			}
		}
		return new FlexibleContext(shape[0], shape[1], shape[2], shape[3], shape[4], shape[5], shape[6], shape[7]);
	}
}

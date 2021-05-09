package io.github.zemelua.umumod.block.blockstateproperty;

import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.Direction;

public class UMUBlockStateProperties {
	public static final IntegerProperty CONNECTION_SWITCH = IntegerProperty.create("switch", 0, 3);

	public static final DirectionProperty FACING_X = DirectionProperty.create("facing_x", Direction.NORTH, Direction.SOUTH);
	public static final DirectionProperty FACING_Y = DirectionProperty.create("facing_y", Direction.DOWN, Direction.UP);
	public static final DirectionProperty FACING_Z = DirectionProperty.create("facing_z", Direction.WEST, Direction.EAST);

	public static final EnumProperty<VerticalSlabType> VERTICAL_SLAB_TYPE = EnumProperty.create("type", VerticalSlabType.class);
	public static final EnumProperty<PostType> POST_TYPE = EnumProperty.create("type", PostType.class);
	public static final EnumProperty<ColumnType> COLUMN_TYPE = EnumProperty.create("type", ColumnType.class);
	public static final EnumProperty<BumpkinPart> BUMPKIN_PART = EnumProperty.create("part", BumpkinPart.class);
}

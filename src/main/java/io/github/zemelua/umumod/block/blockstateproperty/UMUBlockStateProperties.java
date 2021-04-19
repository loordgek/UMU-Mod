package io.github.zemelua.umumod.block.blockstateproperty;

import net.minecraft.state.EnumProperty;

public class UMUBlockStateProperties {
	public static final EnumProperty<VerticalSlabType> VERTICAL_SLAB_TYPE = EnumProperty.create("type", VerticalSlabType.class);
	public static final EnumProperty<ColumnType> COLUMN_TYPE = EnumProperty.create("type", ColumnType.class);
	public static final EnumProperty<BigCubeBlockPart> BIG_CUBE_PART = EnumProperty.create("part", BigCubeBlockPart.class);
}

package io.github.zemelua.umumod.block.blockstateproperty;

import net.minecraft.state.EnumProperty;

public class UMUBlockStateProperties {
	public static final EnumProperty<VerticalSlabType> VERTICAL_SLAB_TYPE = EnumProperty.create("slab_type", VerticalSlabType.class);
	public static final EnumProperty<ColumnType> COLUMN_TYPE = EnumProperty.create("type", ColumnType.class);
}

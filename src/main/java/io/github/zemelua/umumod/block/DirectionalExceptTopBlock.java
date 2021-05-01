package io.github.zemelua.umumod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;

public abstract class DirectionalExceptTopBlock extends Block {
	protected static final DirectionProperty FACING = BlockStateProperties.FACING_EXCEPT_UP;

	public DirectionalExceptTopBlock(Properties properties) {
		super(properties);
	}

	@SuppressWarnings({"deprecation", "NullableProblems"})
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@SuppressWarnings({"deprecation", "NullableProblems"})
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
}

package io.github.zemelua.umumod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class SlidingDoorBlock extends DoorBlock {
	private static final VoxelShape SOUTH_CLOSE = Block.makeCuboidShape(0.0D, 0.0D, 5.0D, 16.0D, 16.0D, 8.0D);
	private static final VoxelShape NORTH_CLOSE = Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 11.0D);
	private static final VoxelShape WEST_CLOSE = Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 11.0D, 16.0D, 16.0D);
	private static final VoxelShape EAST_CLOSE = Block.makeCuboidShape(5.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
	private static final VoxelShape SOUTH_OPEN_LEFT = Block.makeCuboidShape(-11.0D, 0.0D, 5.0D, 5.0D, 16.0D, 8.0D);
	private static final VoxelShape NORTH_OPEN_LEFT = Block.makeCuboidShape(11.0D, 0.0D, 8.0D, 27.0D, 16.0D, 11.0D);
	private static final VoxelShape WEST_OPEN_LEFT = Block.makeCuboidShape(8.0D, 0.0D, 11.0D, 11.0D, 16.0D, 27.0D);
	private static final VoxelShape EAST_OPEN_LEFT = Block.makeCuboidShape(5.0D, 0.0D, -11.0D, 8.0D, 16.0D, 5.0D);
	private static final VoxelShape SOUTH_OPEN_RIGHT = Block.makeCuboidShape(11.0D, 0.0D, 5.0D, 27.0D, 16.0D, 8.0D);
	private static final VoxelShape NORTH_OPEN_RIGHT = Block.makeCuboidShape(-11.0D, 0.0D, 8.0D, 5.0D, 16.0D, 11.0D);
	private static final VoxelShape WEST_OPEN_RIGHT = Block.makeCuboidShape(8.0D, 0.0D, -11.0D, 11.0D, 16.0D, 5.0D);
	private static final VoxelShape EAST_OPEN_RIGHT = Block.makeCuboidShape(5.0D, 0.0D, 11.0D, 8.0D, 16.0D, 27.0D);

	public SlidingDoorBlock(Properties builder) {
		super(builder);
	}

	@SuppressWarnings("NullableProblems")
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(FACING);
		boolean isntOpen = !state.get(OPEN);
		boolean isHingeRight = state.get(HINGE) == DoorHingeSide.RIGHT;
		switch (direction) {
			case SOUTH:
				return isntOpen ? SOUTH_CLOSE : (isHingeRight ? SOUTH_OPEN_RIGHT : SOUTH_OPEN_LEFT);
			case NORTH:
				return isntOpen ? NORTH_CLOSE : (isHingeRight ? NORTH_OPEN_RIGHT : NORTH_OPEN_LEFT);
			case WEST:
				return isntOpen ? WEST_CLOSE : (isHingeRight ? WEST_OPEN_RIGHT : WEST_OPEN_LEFT);
			case EAST:
			default:
				return isntOpen ? EAST_CLOSE : (isHingeRight ? EAST_OPEN_RIGHT : EAST_OPEN_LEFT);
		}
	}
}

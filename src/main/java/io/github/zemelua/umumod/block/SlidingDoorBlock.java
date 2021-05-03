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

	/*
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockPos = context.getPos();
		if (blockPos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context)) {
			World world = context.getWorld();
			boolean isPowered = world.isBlockPowered(blockpos) || world.isBlockPowered(blockpos.up());
			Pair<Direction, DoorHingeSide> facingAndHinge = this.getFacingAndHinge(context);
			return this.getDefaultState()
					.with(FACING, facingAndHinge.getKey())
					.with(OPEN, isPowered)
					.with(HINGE, facingAndHinge.getValue())
					.with(POWERED, isPowered)
					.with(HALF, DoubleBlockHalf.LOWER);
		} else {
			return null;
		}
	}

	private Pair<Direction, DoorHingeSide> getFacingAndHinge(BlockItemUseContext context) {
		IBlockReader world = context.getWorld();
		BlockPos blockPos = context.getPos();
		Direction direction = context.getPlacementHorizontalFacing();
		BlockState leftState = world.getBlockState(blockPos.offset(direction.rotateYCCW()));
		BlockState rightState = world.getBlockState(blockPos.offset(direction.rotateY()));
		if (leftState.matchesBlock(this) && rightState.matchesBlock(this)) {
			if (leftState.get(FACING).getAxis() == direction.getAxis() && rightState.get(FACING).getAxis() == direction.getAxis()) {
				return new Pair<>(direction, getHingeSide(context));
			}
		} else if (leftState.matchesBlock(this)) {
			if (leftState.get(FACING) == direction) {
				if (leftState.get(HINGE) == DoorHingeSide.LEFT) {
					return new Pair<>(direction, DoorHingeSide.RIGHT);
				} else {
					return new Pair<>(direction.getOpposite(), DoorHingeSide.LEFT);
				}
			} else if (leftState.get(FACING) == direction.getOpposite()) {
				if (leftState.get(HINGE) == DoorHingeSide.LEFT) {
					return new Pair<>(direction.getOpposite(), DoorHingeSide.RIGHT);
				} else {
					return new Pair<>(direction, DoorHingeSide.LEFT);
				}
			}
		} else if (rightState.matchesBlock(this)) {
			if (rightState.get(FACING) == direction) {
				if (rightState.get(HINGE) == DoorHingeSide.LEFT) {
					return new Pair<>(direction.getOpposite(), DoorHingeSide.RIGHT);
				} else {
					return new Pair<>(direction, DoorHingeSide.LEFT);
				}
			} else if (rightState.get(FACING) == direction.getOpposite()) {
				if (rightState.get(HINGE) == DoorHingeSide.LEFT) {
					return new Pair<>(direction, DoorHingeSide.RIGHT);
				} else {
					return new Pair<>(direction.getOpposite(), DoorHingeSide.LEFT);
				}
			}
		}

		return new Pair<>(direction, getHingeSide(context));
	}

	@Deprecated
	private DoorHingeSide getHingeSide(BlockItemUseContext context) {
		BlockPos blockPos = context.getPos();
		Direction direction = context.getPlacementHorizontalFacing();
		Vector3d hitVec = context.getHitVec();
		int xOffset = direction.getXOffset();
		int zOffset = direction.getZOffset();
		double xHitVec = hitVec.getX() - (double) blockPos.getX();
		double zHitVec = hitVec.getZ() - (double) blockPos.getZ();
		return (xOffset >= 0 || !(zHitVec < 0.5D)) && (xOffset <= 0 || !(zHitVec > 0.5D)) && (zOffset >= 0 || !(xHitVec > 0.5D)) && (zOffset <= 0 || !(xHitVec < 0.5D))
				? DoorHingeSide.LEFT
				: DoorHingeSide.RIGHT;
	}

	 */
}

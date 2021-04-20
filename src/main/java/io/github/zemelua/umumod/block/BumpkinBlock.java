package io.github.zemelua.umumod.block;

import io.github.zemelua.umumod.block.blockstateproperty.UMUBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BumpkinBlock extends Block {
	private static final DirectionProperty FACING_X = UMUBlockStateProperties.FACING_X;
	private static final DirectionProperty FACING_Y = UMUBlockStateProperties.FACING_Y;
	private static final DirectionProperty FACING_Z = UMUBlockStateProperties.FACING_Z;
	private static final VoxelShape DOWN_NORTH_WEST_SHAPE = VoxelShapes.or(
			Block.makeCuboidShape(11, 0, 3, 16, 16, 6),
			Block.makeCuboidShape(3, 0, 11, 6, 16, 16),
			Block.makeCuboidShape(6, 0, 6, 16, 16, 16)
	);
	private static final VoxelShape DOWN_NORTH_EAST_SHAPE = VoxelShapes.or(
			Block.makeCuboidShape(0, 0, 3, 5, 16, 6),
			Block.makeCuboidShape(10, 0, 11, 13, 16, 16),
			Block.makeCuboidShape(0, 0, 6, 10, 16, 16)
	);
	private static final VoxelShape DOWN_SOUTH_WEST_SHAPE = VoxelShapes.or(
			Block.makeCuboidShape(11, 0, 10, 16, 16, 13),
			Block.makeCuboidShape(3, 0, 0, 6, 16, 5),
			Block.makeCuboidShape(6, 0, 0, 16, 16, 10)
	);
	private static final VoxelShape DOWN_SOUTH_EAST_SHAPE = VoxelShapes.or(
			Block.makeCuboidShape(0, 0, 10, 5, 16, 13),
			Block.makeCuboidShape(10, 0, 0, 13, 16, 5),
			Block.makeCuboidShape(0, 0, 0, 10, 16, 10)
	);
	private static final VoxelShape UP_NORTH_WEST_SHAPE = VoxelShapes.or(
			Block.makeCuboidShape(11, 0, 3, 16, 5, 6),
			Block.makeCuboidShape(3, 0, 11, 6, 5, 16),
			Block.makeCuboidShape(6, 0, 6, 16, 5, 16)
	);
	private static final VoxelShape UP_NORTH_EAST_SHAPE = VoxelShapes.or(
			Block.makeCuboidShape(0, 0, 3, 5, 5, 6),
			Block.makeCuboidShape(10, 0, 11, 13, 5, 16),
			Block.makeCuboidShape(0, 0, 6, 10, 5, 16)
	);
	private static final VoxelShape UP_SOUTH_WEST_SHAPE = VoxelShapes.or(
			Block.makeCuboidShape(11, 0, 10, 16, 5, 13),
			Block.makeCuboidShape(3, 0, 0, 6, 5, 5),
			Block.makeCuboidShape(6, 0, 0, 16, 5, 10)
	);
	private static final VoxelShape UP_SOUTH_EAST_SHAPE = VoxelShapes.or(
			Block.makeCuboidShape(0, 0, 10, 5, 5, 13),
			Block.makeCuboidShape(10, 0, 0, 13, 5, 5),
			Block.makeCuboidShape(0, 0, 0, 10, 5, 10)
	);

	public BumpkinBlock(Properties builder) {
		super(builder);
		this.setDefaultState(this.getStateContainer().getBaseState()
				.with(FACING_X, Direction.NORTH).with(FACING_Y, Direction.DOWN).with(FACING_Z, Direction.WEST)
		);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction x = state.get(FACING_X);
		Direction y = state.get(FACING_Y);
		Direction z = state.get(FACING_Z);
		if (x == Direction.NORTH && y == Direction.DOWN && z == Direction.WEST) {
			return DOWN_NORTH_WEST_SHAPE;
		} else if (x == Direction.NORTH && y == Direction.DOWN && z == Direction.EAST) {
			return DOWN_NORTH_EAST_SHAPE;
		} else if (x == Direction.SOUTH && y == Direction.DOWN && z == Direction.WEST) {
			return DOWN_SOUTH_WEST_SHAPE;
		} else if (x == Direction.SOUTH && y == Direction.DOWN && z == Direction.EAST) {
			return DOWN_SOUTH_EAST_SHAPE;
		} else if (x == Direction.NORTH && y == Direction.UP && z == Direction.WEST) {
			return UP_NORTH_WEST_SHAPE;
		} else if (x == Direction.NORTH && y == Direction.UP && z == Direction.EAST) {
			return UP_NORTH_EAST_SHAPE;
		} else if (x == Direction.SOUTH && y == Direction.UP && z == Direction.WEST) {
			return UP_SOUTH_WEST_SHAPE;
		} else {
			return UP_SOUTH_EAST_SHAPE;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockPos = context.getPos();
		Direction face = context.getPlacementHorizontalFacing().getOpposite();
		World world = context.getWorld();

		if (blockPos.getY() < 255
				&& world.getBlockState(blockPos.offset(face.rotateY())).isReplaceable(context)
				&& world.getBlockState(blockPos.offset(face.getOpposite())).isReplaceable(context)
				&& world.getBlockState(blockPos.offset(face.getOpposite()).offset(face.rotateY())).isReplaceable(context)
				&& world.getBlockState(blockPos.up()).isReplaceable(context)
				&& world.getBlockState(blockPos.up().offset(face.rotateY())).isReplaceable(context)
				&& world.getBlockState(blockPos.up().offset(face.getOpposite())).isReplaceable(context)
				&& world.getBlockState(blockPos.up().offset(face.getOpposite()).offset(face.rotateY())).isReplaceable(context)
		) {
			return this.getDefaultState()
					.with(FACING_X, face == Direction.NORTH || face == Direction.EAST ? Direction.NORTH : Direction.SOUTH)
					.with(FACING_Z, face == Direction.WEST || face == Direction.NORTH ? Direction.WEST : Direction.EAST);
		}
		return null;
	}
}

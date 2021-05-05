package io.github.zemelua.umumod.block;

import io.github.zemelua.umumod.block.blockstateproperty.PostType;
import io.github.zemelua.umumod.block.blockstateproperty.UMUBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class PostBlock extends Block implements IWaterLoggable {
	private static final EnumProperty<PostType> TYPE = UMUBlockStateProperties.POST_TYPE;
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	private static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 12.0D, 16.0D, 8.0D);
	private static final VoxelShape NORTH_WEST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 8.0D);
	private static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 8.0D, 16.0D, 12.0D);
	private static final VoxelShape WEST_SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 16.0D, 16.0D);
	private static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 8.0D, 12.0D, 16.0D, 16.0D);
	private static final VoxelShape SOUTH_EAST_SHAPE = Block.makeCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(8.0D, 0.0D, 4.0D, 16.0D, 16.0D, 12.0D);
	private static final VoxelShape EAST_NORTH_SHAPE = Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
	private static final VoxelShape CENTER_SHAPE = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

	public PostBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.getDefaultState().with(TYPE, PostType.NORTH).with(WATERLOGGED, Boolean.TRUE));
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos pos = context.getPos();
		Direction.Axis axis = context.getFace().getAxis();
		Vector3d hitVec = context.getHitVec();
		double xHit = hitVec.getX() - (double) pos.getX();
		double zHit = hitVec.getZ() - (double) pos.getZ();

		int index = -1;
		LOOP:
		for (int ix = 0; ix < 3; ix++) {
			for (int iz = 0; iz < 3; iz++) {
				index++;
				if ((xHit > (double) ix / 3.0D && xHit < ((double) ix + 1.0D) / 3.0D)
						&& (zHit > (double) iz / 3.0D && zHit < ((double) iz + 1.0D) / 3.0D)) {
					break LOOP;
				}
			}
		}

		return this.getDefaultState().with(TYPE, PostType.getByIndex(index));
	}

	@SuppressWarnings({"NullableProblems", "deprecation"})
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		PostType type = state.get(TYPE);
		switch (type) {
			default:
			case NORTH:      return NORTH_SHAPE;
			case NORTH_WEST: return NORTH_WEST_SHAPE;
			case WEST:       return WEST_SHAPE;
			case WEST_SOUTH: return WEST_SOUTH_SHAPE;
			case SOUTH:      return SOUTH_SHAPE;
			case SOUTH_EAST: return SOUTH_EAST_SHAPE;
			case EAST:       return EAST_SHAPE;
			case EAST_NORTH: return EAST_NORTH_SHAPE;
			case CENTER:     return CENTER_SHAPE;
		}
	}

	@SuppressWarnings({"NullableProblems", "deprecation"})
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(TYPE, WATERLOGGED);
	}
}

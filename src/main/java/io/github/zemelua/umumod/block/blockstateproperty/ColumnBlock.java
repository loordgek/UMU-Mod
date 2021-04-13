package io.github.zemelua.umumod.block.blockstateproperty;

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
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class ColumnBlock extends Block implements IWaterLoggable {
	public static final EnumProperty<ColumnType> COLUMN_TYPE = UMUBlockStateProperties.COLUMN_TYPE;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	private static final VoxelShape COLUMN_TOP_SHAPE = VoxelShapes.or(
		Block.makeCuboidShape(2, 0, 2, 14, 12, 14),
		Block.makeCuboidShape(0, 12, 0, 16, 16, 16)
	);
	private static final VoxelShape COLUMN_MIDDLE_SHAPE = VoxelShapes.or(
		Block.makeCuboidShape(2, 0, 2, 14, 16, 14)
	);
	private static final VoxelShape COLUMN_BOTTOM_SHAPE = VoxelShapes.or(
		Block.makeCuboidShape(2, 4, 2, 14, 16, 14),
		Block.makeCuboidShape(0, 0, 0, 16, 4, 16)
	);

	public ColumnBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.getStateContainer().getBaseState()
			.with(COLUMN_TYPE, ColumnType.MIDDLE)
			.with(WATERLOGGED, false)
		);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IWorldReader iworldreader = context.getWorld();
		BlockPos blockpos = context.getPos();
		FluidState fluidstate = iworldreader.getFluidState(blockpos);
		return getThisState(iworldreader, blockpos).with(WATERLOGGED, fluidstate.getFluid() == Fluids.WATER);
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}

		return this.getThisState(worldIn, currentPos).with(WATERLOGGED, stateIn.get(WATERLOGGED));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(
			COLUMN_TYPE,
			WATERLOGGED
		);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(COLUMN_TYPE)) {
			case TOP:
				return COLUMN_TOP_SHAPE;
			case MIDDLE:
				return COLUMN_MIDDLE_SHAPE;
			case BOTTOM:
				return COLUMN_BOTTOM_SHAPE;
			default:
				return COLUMN_MIDDLE_SHAPE;
		}
	}

	private BlockState getThisState(IBlockReader world, BlockPos pos) {
		boolean hasUp = world.getBlockState(pos.up()).getBlock() instanceof ColumnBlock;
		boolean hasDown = world.getBlockState(pos.down()).getBlock() instanceof ColumnBlock;
		ColumnType type = ColumnType.MIDDLE;
		if (hasUp && !hasDown) {
			type = ColumnType.BOTTOM;
		} else if (!hasUp && hasDown) {
			type = ColumnType.TOP;
		}
		return this.getDefaultState().with(COLUMN_TYPE, type);
	}
}
package io.github.zemelua.umumod.block;

import io.github.zemelua.umumod.block.blockstateproperty.UMUBlockStateProperties;
import io.github.zemelua.umumod.block.blockstateproperty.VerticalSlabType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

public class VerticalSlabBlock extends Block implements IWaterLoggable {
	public static final EnumProperty<VerticalSlabType> TYPE = UMUBlockStateProperties.VERTICAL_SLAB_TYPE;
	private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final VoxelShape NORTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 8.0D);
	private static final VoxelShape SOUTH_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape WEST_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 16.0D);
	private static final VoxelShape EAST_SHAPE = Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public VerticalSlabBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.getDefaultState().with(TYPE, VerticalSlabType.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
	}

	@Override
	public boolean isTransparent(BlockState state) {
		return state.get(TYPE) != VerticalSlabType.DOUBLE;
	}

	@Override
	public void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(TYPE, WATERLOGGED);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		VerticalSlabType verticalSlabType = state.get(TYPE);
		switch(verticalSlabType) {
			case DOUBLE: return VoxelShapes.fullCube();
			case NORTH: return NORTH_SHAPE;
			case SOUTH: return SOUTH_SHAPE;
			case WEST: return WEST_SHAPE;
			default: return EAST_SHAPE;
		}
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		BlockState blockstate = context.getWorld().getBlockState(blockpos);
		if (blockstate.matchesBlock(this)) {
			return blockstate.with(TYPE, VerticalSlabType.DOUBLE).with(WATERLOGGED, Boolean.valueOf(false));
		} else {
			FluidState fluidstate = context.getWorld().getFluidState(blockpos);
			BlockState blockstate1 = this.getDefaultState().with(TYPE, VerticalSlabType.SOUTH).with(WATERLOGGED, Boolean.valueOf(fluidstate.getFluid() == Fluids.WATER));
			Direction direction = getDirectionForPlacement(context);
			switch (direction) {
				case SOUTH: return blockstate1.with(TYPE, VerticalSlabType.NORTH);
				case WEST: return blockstate1.with(TYPE, VerticalSlabType.EAST);
				case EAST: return blockstate1.with(TYPE, VerticalSlabType.WEST);
				default: return blockstate1;
			}
		}
	}

	private Direction getDirectionForPlacement(BlockItemUseContext context) {
		Direction direction = context.getFace();
		if(direction.getAxis() != Direction.Axis.Y)
			return direction;

		BlockPos pos = context.getPos();
		Vector3d vec = context.getHitVec().subtract(new Vector3d(pos.getX(), pos.getY(), pos.getZ())).subtract(0.5, 0, 0.5);
		double angle = Math.atan2(vec.x, vec.z) * -180.0 / Math.PI;
		return Direction.fromAngle(angle).getOpposite();
	}

	@Override
	public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
		ItemStack itemstack = useContext.getItem();
		VerticalSlabType slabtype = state.get(TYPE);

		if (slabtype != VerticalSlabType.DOUBLE && itemstack.getItem() == this.asItem()) {
			if (useContext.replacingClickedOnBlock()) {
				Direction direction = getDirectionForPlacement(useContext);
				if (slabtype == VerticalSlabType.NORTH) {
					return direction == Direction.SOUTH || useContext.getFace().getAxis() != Direction.NORTH.getAxis();
				} else if (slabtype == VerticalSlabType.SOUTH) {
					return direction == Direction.NORTH || useContext.getFace().getAxis() != Direction.SOUTH.getAxis();
				} else if (slabtype == VerticalSlabType.WEST) {
					return direction == Direction.EAST || useContext.getFace().getAxis() != Direction.WEST.getAxis();
				} else {
					return direction == Direction.WEST || useContext.getFace().getAxis() != Direction.EAST.getAxis();
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@Override
	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
		return state.get(TYPE) != VerticalSlabType.DOUBLE && IWaterLoggable.super.receiveFluid(worldIn, pos, state, fluidStateIn);
	}

	@Override
	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return state.get(TYPE) != VerticalSlabType.DOUBLE && IWaterLoggable.super.canContainFluid(worldIn, pos, state, fluidIn);
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}

		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		if (type == PathType.WATER) {
			return worldIn.getFluidState(pos).isTagged(FluidTags.WATER);
		}
		return false;
	}
}

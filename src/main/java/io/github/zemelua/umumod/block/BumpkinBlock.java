package io.github.zemelua.umumod.block;

import io.github.zemelua.umumod.block.blockstateproperty.BumpkinPart;
import io.github.zemelua.umumod.block.blockstateproperty.UMUBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Optional;

public class BumpkinBlock extends HorizontalBlock {
	private static final EnumProperty<BumpkinPart> PART = UMUBlockStateProperties.BUMPKIN_PART;
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
				.with(PART, BumpkinPart.LOWER_FRONT_LEFT).with(HORIZONTAL_FACING, Direction.NORTH)
		);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(HORIZONTAL_FACING)) {
			case NORTH:
				switch (state.get(PART)) {
					case LOWER_FRONT_LEFT: return DOWN_NORTH_WEST_SHAPE;
					case LOWER_FRONT_RIGHT: return DOWN_NORTH_EAST_SHAPE;
					case LOWER_BACK_LEFT: return DOWN_SOUTH_WEST_SHAPE;
					case LOWER_BACK_RIGHT: return DOWN_SOUTH_EAST_SHAPE;
					case UPPER_FRONT_LEFT: return UP_NORTH_WEST_SHAPE;
					case UPPER_FRONT_RIGHT: return UP_NORTH_EAST_SHAPE;
					case UPPER_BACK_LEFT: return UP_SOUTH_WEST_SHAPE;
					case UPPER_BACK_RIGHT: return UP_SOUTH_EAST_SHAPE;
				}
			case SOUTH:
				switch (state.get(PART)) {
					case LOWER_FRONT_LEFT: return DOWN_SOUTH_EAST_SHAPE;
					case LOWER_FRONT_RIGHT: return DOWN_SOUTH_WEST_SHAPE;
					case LOWER_BACK_LEFT: return DOWN_NORTH_EAST_SHAPE;
					case LOWER_BACK_RIGHT: return DOWN_NORTH_WEST_SHAPE;
					case UPPER_FRONT_LEFT: return UP_SOUTH_EAST_SHAPE;
					case UPPER_FRONT_RIGHT: return UP_SOUTH_WEST_SHAPE;
					case UPPER_BACK_LEFT: return UP_NORTH_EAST_SHAPE;
					case UPPER_BACK_RIGHT: return UP_NORTH_WEST_SHAPE;
				}
			case WEST:
				switch (state.get(PART)) {
					case LOWER_FRONT_LEFT: return DOWN_SOUTH_WEST_SHAPE;
					case LOWER_FRONT_RIGHT: return DOWN_NORTH_WEST_SHAPE;
					case LOWER_BACK_LEFT: return DOWN_SOUTH_EAST_SHAPE;
					case LOWER_BACK_RIGHT: return DOWN_NORTH_EAST_SHAPE;
					case UPPER_FRONT_LEFT: return UP_SOUTH_WEST_SHAPE;
					case UPPER_FRONT_RIGHT: return UP_NORTH_WEST_SHAPE;
					case UPPER_BACK_LEFT: return UP_SOUTH_EAST_SHAPE;
					case UPPER_BACK_RIGHT: return UP_NORTH_EAST_SHAPE;
				}
			case EAST:
				switch (state.get(PART)) {
					case LOWER_FRONT_LEFT: return DOWN_NORTH_EAST_SHAPE;
					case LOWER_FRONT_RIGHT: return DOWN_SOUTH_EAST_SHAPE;
					case LOWER_BACK_LEFT: return DOWN_NORTH_WEST_SHAPE;
					case LOWER_BACK_RIGHT: return DOWN_SOUTH_WEST_SHAPE;
					case UPPER_FRONT_LEFT: return UP_NORTH_EAST_SHAPE;
					case UPPER_FRONT_RIGHT: return UP_SOUTH_EAST_SHAPE;
					case UPPER_BACK_LEFT: return UP_NORTH_WEST_SHAPE;
					case UPPER_BACK_RIGHT: return UP_SOUTH_WEST_SHAPE;
				}
			default: return VoxelShapes.fullCube();
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos pos = context.getPos();
		Direction face = context.getPlacementHorizontalFacing();
		World world = context.getWorld();

		if (pos.getY() < 255
				&& world.getBlockState(pos.offset(face.rotateYCCW())).isReplaceable(context)
				&& world.getBlockState(pos.offset(face)).isReplaceable(context)
				&& world.getBlockState(pos.offset(face).offset(face.rotateYCCW())).isReplaceable(context)
				&& world.getBlockState(pos.up()).isReplaceable(context)
				&& world.getBlockState(pos.up().offset(face.rotateYCCW())).isReplaceable(context)
				&& world.getBlockState(pos.up().offset(face)).isReplaceable(context)
				&& world.getBlockState(pos.up().offset(face).offset(face.rotateYCCW())).isReplaceable(context)
		) {
			return this.getDefaultState().with(HORIZONTAL_FACING, face.getOpposite());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		Direction face = Optional.ofNullable(placer).map(Entity::getHorizontalFacing).orElse(Direction.NORTH);
		worldIn.setBlockState(pos.offset(face.rotateYCCW()), state.with(PART, BumpkinPart.LOWER_FRONT_RIGHT));
		worldIn.setBlockState(pos.offset(face), state.with(PART, BumpkinPart.LOWER_BACK_LEFT));
		worldIn.setBlockState(pos.offset(face).offset(face.rotateYCCW()), state.with(PART, BumpkinPart.LOWER_BACK_RIGHT));
		worldIn.setBlockState(pos.up(), state.with(PART, BumpkinPart.UPPER_FRONT_LEFT));
		worldIn.setBlockState(pos.up().offset(face.rotateYCCW()), state.with(PART, BumpkinPart.UPPER_FRONT_RIGHT));
		worldIn.setBlockState(pos.up().offset(face), state.with(PART, BumpkinPart.UPPER_BACK_LEFT));
		worldIn.setBlockState(pos.up().offset(face).offset(face.rotateYCCW()), state.with(PART, BumpkinPart.UPPER_BACK_RIGHT));
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (facing.getAxis() != Direction.Axis.Y) {
			switch (stateIn.get(PART)) {
				case LOWER_FRONT_LEFT:
					if (worldIn.getBlockState(currentPos.offset(facing.rotateYCCW())).matchesBlock(this)
							&& worldIn.getBlockState(currentPos.offset(facing)).matchesBlock(this)
							&& worldIn.getBlockState(currentPos.offset(facing).offset(facing.rotateYCCW())).matchesBlock(this)
							&& worldIn.getBlockState(currentPos.up()).matchesBlock(this)
							&& worldIn.getBlockState(currentPos.up().offset(facing.rotateYCCW())).matchesBlock(this)
							&& worldIn.getBlockState(currentPos.up().offset(facing)).matchesBlock(this)
							&& worldIn.getBlockState(currentPos.up().offset(facing).offset(facing.rotateYCCW())).matchesBlock(this)
					) {

					}
			}

		}
		return null;
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(PART, HORIZONTAL_FACING);
	}
}

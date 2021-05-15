package io.github.zemelua.umumod.block;

import io.github.zemelua.umumod.block.blockstateproperty.UMUBlockStateProperties;
import io.github.zemelua.umumod.block.blockstateproperty.WoodenBoxContents;
import io.github.zemelua.umumod.tileentity.ThinWoodenBoxTileEntity;
import io.github.zemelua.umumod.tileentity.WoodenBoxTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.SlabType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ThinWoodenBoxBlock extends SlabBlock {
	public static final EnumProperty<WoodenBoxContents> ITEM = UMUBlockStateProperties.WOODEN_BOX_ITEM;

	public ThinWoodenBoxBlock(Properties properties) {
		super(properties);
	}

	@SuppressWarnings({"deprecation", "DuplicatedCode", "NullableProblems"})
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		if (tileEntity instanceof WoodenBoxTileEntity) {
			WoodenBoxTileEntity woodenBoxTileEntity = (WoodenBoxTileEntity) tileEntity;
			ItemStack itemStack = player.getHeldItem(handIn);
			Item item = itemStack.getItem();

			if (!(itemStack.isEmpty() && woodenBoxTileEntity.getContents().isEmpty())) {
				if (WoodenBoxContents.isValidItem(item)) {
					if (woodenBoxTileEntity.isFull(state.get(TYPE))
							|| (!itemStack.isEmpty() && !woodenBoxTileEntity.isEmpty() && item != woodenBoxTileEntity.getItem())) {
						return ActionResultType.PASS;
					}

					ItemStack putStack;
					if (state.get(TYPE) == SlabType.DOUBLE) {
						putStack = woodenBoxTileEntity.putItem(itemStack.copy());
					} else {
						putStack = woodenBoxTileEntity.putItem(itemStack.copy().split(itemStack.getMaxStackSize() / 2));
						putStack.grow(itemStack.getCount());
					}
					worldIn.setBlockState(pos, state.with(ITEM, WoodenBoxContents.getByItem(item)));
					if (!player.abilities.isCreativeMode) {
						player.setHeldItem(handIn, putStack);
					}
				} else {
					if (woodenBoxTileEntity.isEmpty()) {
						return ActionResultType.PASS;
					}

					ItemStack takeStack = woodenBoxTileEntity.takeItem();
					if (itemStack.isEmpty()) {
						player.setHeldItem(handIn, takeStack);
					} else if (!player.addItemStackToInventory(takeStack)) {
						player.dropItem(takeStack, false);
					}

					worldIn.setBlockState(pos, state.with(ITEM, WoodenBoxContents.EMPTY));
					return ActionResultType.func_233537_a_(worldIn.isRemote());
				}
			}

			return ActionResultType.PASS;
		}

		return ActionResultType.CONSUME;
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (!state.matchesBlock(newState.getBlock())) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof IInventory) {
				InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
			}

			super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(ITEM);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new ThinWoodenBoxTileEntity();
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
}

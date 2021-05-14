package io.github.zemelua.umumod.tileentity;

import io.github.zemelua.umumod.util.ItemStackUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;

import java.util.Objects;

public class ThinWoodenBoxTileEntity extends WoodenBoxTileEntity {
	public ThinWoodenBoxTileEntity() {
		super(UMUTileEntities.THIN_WOODEN_BOX.get());
	}

	@Override
	public void setContents(ItemStack itemStack) {
		BlockState blockState = Objects.requireNonNull(this.getWorld()).getBlockState(this.getPos());
		SlabType slabType = blockState.get(BlockStateProperties.SLAB_TYPE);
		if (!(blockState.getBlock() instanceof SlabBlock) || slabType == SlabType.DOUBLE) {
			super.setContents(itemStack);
			return;
		}

		this.contents = itemStack.split(32);
	}

	@Override
	public ItemStack putItem(ItemStack itemStack) {
		BlockState blockState = Objects.requireNonNull(this.getWorld()).getBlockState(this.getPos());
		SlabType slabType = blockState.get(BlockStateProperties.SLAB_TYPE);
		if (!(blockState.getBlock() instanceof SlabBlock) || slabType == SlabType.DOUBLE) {
			return super.putItem(itemStack);
		}
		ItemStack thisStack = this.getContents();
		if (thisStack.isEmpty()) {
			this.setContents(itemStack.copy());
			ItemStack putStack = itemStack.copy();
			putStack.split(putStack.getMaxStackSize() / 2);
			return putStack;
		} else if (ItemStackUtil.canCombine(thisStack, itemStack)) {
			int putCount = Math.min(itemStack.getCount(), itemStack.getMaxStackSize() / 2 - thisStack.getCount());
			thisStack.grow(putCount);
			ItemStack putStack = itemStack.copy();
			putStack.split(putCount);
			return putStack;
		}
		return itemStack;
	}

	@Override
	public boolean isFull(SlabType type) {
		if (type == null || type == SlabType.DOUBLE) {
			return super.isFull(null);
		}

		ItemStack itemStack = this.getContents();
		return !itemStack.isEmpty() && itemStack.getMaxStackSize() / 2 == itemStack.getCount();
	}
}

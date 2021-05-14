package io.github.zemelua.umumod.tileentity;

import io.github.zemelua.umumod.util.ItemStackUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.SlabType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

import java.util.Objects;

public class WoodenBoxTileEntity extends TileEntity implements IInventory {
	protected ItemStack contents = ItemStack.EMPTY;

	protected WoodenBoxTileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
	}

	public WoodenBoxTileEntity() {
		super(UMUTileEntities.WOODEN_BOX.get());
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public boolean isEmpty() {
		return contents.isEmpty();
	}

	@SuppressWarnings("NullableProblems")
	@Override
	public ItemStack getStackInSlot(int index) {
		return index == 0 ? this.contents : ItemStack.EMPTY;
	}

	@SuppressWarnings("NullableProblems")
	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (index == 0) {
			return this.getContents().split(count);
		}
		return ItemStack.EMPTY;
	}

	@SuppressWarnings("NullableProblems")
	@Override
	public ItemStack removeStackFromSlot(int index) {
		if (index == 0) {
			ItemStack itemstack = this.contents;
			this.contents = ItemStack.EMPTY;
			return itemstack;
		} else {
			return ItemStack.EMPTY;
		}
	}

	@SuppressWarnings("NullableProblems")
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
	}

	@SuppressWarnings("NullableProblems")
	@Override
	public boolean isUsableByPlayer(PlayerEntity player) {
		if (Objects.requireNonNull(this.getWorld()).getTileEntity(this.getPos()) != this) {
			return false;
		} else {
			return !(player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) > 64.0D)
					&& this.hasContents();
		}
	}

	@Override
	public void clear() {
		this.contents = ItemStack.EMPTY;
	}

	public ItemStack getContents() {
		return this.contents;
	}

	public Item getItem() {
		return this.getContents().getItem();
	}

	public void setContents(ItemStack itemStack) {
		this.contents = itemStack.copy();
	}

	public ItemStack putItem(ItemStack itemStack) {
		ItemStack thisStack = this.getContents();
		if (thisStack.isEmpty()) {
			this.setContents(itemStack.copy());
			return ItemStack.EMPTY;
		} else if (ItemStackUtil.canCombine(thisStack, itemStack)) {
			int putCount = Math.min(itemStack.getCount(), itemStack.getMaxStackSize() - thisStack.getCount());
			thisStack.grow(putCount);
			ItemStack putStack = itemStack.copy();
			putStack.split(putCount);
			return putStack;
		}
		return itemStack;
	}

	public ItemStack takeItem() {
		ItemStack thisStack = this.getContents();
		this.setContents(ItemStack.EMPTY);
		return thisStack.copy();
	}

	private boolean hasContents() {
		return this.contents != ItemStack.EMPTY;
	}

	public boolean isFull(SlabType type) {
		ItemStack itemStack = this.getContents();
		return !itemStack.isEmpty() && itemStack.getMaxStackSize() == itemStack.getCount();
	}
}

package io.github.zemelua.umumod.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class WoodenBoxTileEntity extends LockableLootTileEntity {
	private NonNullList<ItemStack> woodenBoxContents = NonNullList.withSize(27, ItemStack.EMPTY);

	public WoodenBoxTileEntity() {
		super(UMUTileEntities.WOODEN_BOX.get());
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
		this.woodenBoxContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if (this.checkLootAndRead(nbt)) {
			ItemStackHelper.loadAllItems(nbt, this.woodenBoxContents);
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT nbt) {
		super.write(nbt);
		if (!this.checkLootAndWrite(nbt)) {
			ItemStackHelper.saveAllItems(nbt, this.woodenBoxContents);
		}

		return nbt;
	}

	@Override
	public NonNullList<ItemStack> getItems() {
		return this.woodenBoxContents;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn) {
		this.woodenBoxContents = itemsIn;
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.wooden_box");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return ChestContainer.createGeneric9X3(id, player, this);
	}

	@Override
	public int getSizeInventory() {
		return 27;
	}
}

package io.github.zemelua.umumod.client.gui.screen.inventory;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public enum InventoryTabCategories {
	PLAYER_BELONGINGS   (new ItemStack(Blocks.CHEST)),
	PLAYER_CRAFTING     (new ItemStack(Blocks.CRAFTING_TABLE)),
	PLAYER_ENCYCLOPEDIA (new ItemStack(Items.BOOK)),
	PLAYER_MAP          (new ItemStack(Items.MAP))
	;

	private final ImmutableList<ItemStack> icons;

	InventoryTabCategories(ItemStack... icons) {
		this.icons = ImmutableList.copyOf(icons);
	}

	public ImmutableList<ItemStack> getIcons() {
		return this.icons;
	}

	public static Screen createScreen(InventoryTabCategories categories) {
		PlayerEntity player = Minecraft.getInstance().player;
		switch (categories) {
			//default:   return new BelongingsInventoryScreen(new BelongingsUMUPlayerContainer(player.inventory, player), player.inventory, StringTextComponent.EMPTY);
		}
		return null;
	}
}

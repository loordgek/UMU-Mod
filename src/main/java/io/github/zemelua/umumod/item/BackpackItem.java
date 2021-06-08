package io.github.zemelua.umumod.item;

import io.github.zemelua.umumod.capability.BackpackCapabilityProvider;
import io.github.zemelua.umumod.client.renderer.model.gui.screen.inventory.BelongingsInventoryScreen;
import io.github.zemelua.umumod.inventory.container.BelongingsUMUPlayerContainer;
import io.github.zemelua.umumod.network.BackpackOpenMessage;
import io.github.zemelua.umumod.network.UMUNetwork;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class BackpackItem extends DyeableArmorItem {
	public BackpackItem(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}

	@Nullable
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
		return new BackpackCapabilityProvider();
	}

	// Test
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		IItemHandler inventory = context.getItem().getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(new ItemStackHandler(36));

		if (!context.getWorld().isRemote()) {
			inventory.insertItem(0, new ItemStack(Items.DIAMOND, 3), false);
			context.getPlayer().sendMessage(new StringTextComponent(inventory.getStackInSlot(0).toString()), null);
		}

		return super.onItemUse(context);
	}

	@Override
	public static ItemStackHandler getInventory(ItemStack backpack) {
		ItemStackHandler empty = new ItemStackHandler(36);
		IItemHandler inventory = backpack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(new ItemStackHandler(36));
		if (backpack.getItem() == UMUItems.BACKPACK.get() && )
	}

	@SubscribeEvent
	public static void onOpenGui(GuiOpenEvent event) {

		PlayerEntity player = Minecraft.getInstance().player;
		if (player == null) return;

		if (!(event.getGui() instanceof InventoryScreen)) return;

		PlayerInventory playerInventory = player.inventory;

		event.setGui(new BelongingsInventoryScreen(new BelongingsUMUPlayerContainer(player.container.windowId, playerInventory, null), playerInventory, StringTextComponent.EMPTY));
		UMUNetwork.sendToServer(new BackpackOpenMessage());
	}
}

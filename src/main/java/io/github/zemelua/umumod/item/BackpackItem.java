package io.github.zemelua.umumod.item;

import io.github.zemelua.umumod.capability.BackpackCapabilityProvider;
import io.github.zemelua.umumod.capability.UMUCapabilities;
import io.github.zemelua.umumod.client.gui.screen.inventory.BelongingsInventoryScreen;
import io.github.zemelua.umumod.fluid.FluidTankHandler;
import io.github.zemelua.umumod.fluid.IFluidTankHandler;
import io.github.zemelua.umumod.inventory.container.BelongingsUMUPlayerContainer;
import io.github.zemelua.umumod.network.BackpackOpenMessage;
import io.github.zemelua.umumod.network.UMUNetwork;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
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
		IItemHandler inventory = context.getItem().getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.WEST).orElse(new ItemStackHandler(36));
		IFluidTankHandler tank = context.getItem().getCapability(UMUCapabilities.FLUID_TANK_HANDLER_CAPABILITY, Direction.NORTH).orElse(new FluidTankHandler(4));

		if (!context.getWorld().isRemote()) {
			inventory.insertItem(0, new ItemStack(Items.DIAMOND, 3), false);
			context.getPlayer().sendMessage(new StringTextComponent(inventory.getStackInSlot(0).toString()), null);

			tank.fill(new FluidStack(Fluids.LAVA, 50), IFluidHandler.FluidAction.EXECUTE);
			context.getPlayer().sendMessage(new StringTextComponent(String.valueOf(tank.getFluidInTank(0).getAmount())), null);
		}

		return super.onItemUse(context);
	}

	@SubscribeEvent
	public static void onOpenGui(GuiOpenEvent event) {

		PlayerEntity player = Minecraft.getInstance().player;
		if (player == null) return;
		if (player.isCreative()) return;

		if (!(event.getGui() instanceof InventoryScreen)) return;

		PlayerInventory playerInventory = player.inventory;

		event.setGui(new BelongingsInventoryScreen(new BelongingsUMUPlayerContainer(player.container.windowId, playerInventory, null), playerInventory, StringTextComponent.EMPTY));
		UMUNetwork.sendToServer(new BackpackOpenMessage());
	}
}

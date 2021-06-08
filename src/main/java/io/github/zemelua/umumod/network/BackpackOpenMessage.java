package io.github.zemelua.umumod.network;

import io.github.zemelua.umumod.inventory.container.BelongingsUMUPlayerContainer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.function.Supplier;

public class BackpackOpenMessage implements IMessage {
	public static void encode(BackpackOpenMessage message, PacketBuffer buffer) {
	}

	public static BackpackOpenMessage decode(PacketBuffer buffer) {
		return new BackpackOpenMessage();
	}

	public static void handle(BackpackOpenMessage message, Supplier<Context> networkContext) {
		ServerPlayerEntity player = networkContext.get().getSender();
		networkContext.get().enqueueWork(() -> {
			NetworkHooks.openGui(player, new SimpleNamedContainerProvider((id, playerInventory, unused) -> {
				return new BelongingsUMUPlayerContainer(id, playerInventory, null);
			}, new StringTextComponent("umu.backpack")));
		});
		networkContext.get().setPacketHandled(true);
	}
}

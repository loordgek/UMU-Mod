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

	public static void handle(BackpackOpenMessage message, Supplier<Context> networkContextSupplier) {
		Context networkContext = networkContextSupplier.get();
		ServerPlayerEntity player = networkContext.getSender();
		if (player == null) return;

		networkContext.enqueueWork(
				() -> NetworkHooks.openGui(player, new SimpleNamedContainerProvider(
						(id, playerInventory, unused) -> new BelongingsUMUPlayerContainer(id, playerInventory, null),
						new StringTextComponent("umu.backpack")
				))
		);
		networkContext.setPacketHandled(true);
	}
}

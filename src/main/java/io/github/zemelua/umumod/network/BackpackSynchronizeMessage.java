package io.github.zemelua.umumod.network;

//public class BackpackSynchronizeMessage implements IMessage {
//	private final ItemStackHandler inventory;
//	private final int backpackLocation;
//
//	public BackpackSynchronizeMessage(ItemStackHandler inventory, int backpackLocation) {
//		this.inventory = inventory;
//		this.backpackLocation = backpackLocation;
//	}
//
//	public static void encode(BackpackSynchronizeMessage message, PacketBuffer buffer) {
//	}
//
//	public static BackpackSynchronizeMessage decode(PacketBuffer buffer) {
//		return new BackpackSynchronizeMessage(buffer.read, backpackLocation);
//	}
//
//	public static void handle(BackpackSynchronizeMessage message, Supplier<NetworkEvent.Context> networkContextSupplier) {
//		NetworkEvent.Context networkContext = networkContextSupplier.get();
//		ServerPlayerEntity player = networkContext.getSender();
//		if (player == null) return;
//
//		networkContext.enqueueWork(
//				() -> NetworkHooks.openGui(player, new SimpleNamedContainerProvider(
//						(id, playerInventory, unused) -> new BelongingsUMUPlayerContainer(id, playerInventory, null),
//						new StringTextComponent("umu.backpack")
//				))
//		);
//		networkContext.setPacketHandled(true);
//	}
//}

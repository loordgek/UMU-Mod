package io.github.zemelua.umumod.network;

import io.github.zemelua.umumod.UMUMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class UMUNetwork {
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(UMUMod.MODID, "main"),
			() -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals
	);

	public static void packetRegister() {
		INSTANCE.registerMessage(
				0,
				BackpackOpenMessage.class,
				BackpackOpenMessage::encode,
				BackpackOpenMessage::decode,
				BackpackOpenMessage::handle
		);
	}

	public static void sendToServer(IMessage message) {
		INSTANCE.sendToServer(message);
	}
}

package io.github.zemelua.umumod.inventory.container;

import io.github.zemelua.umumod.UMUMod;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UMUContainers {
	public static final DeferredRegister<ContainerType<?>> CONTAINER = DeferredRegister.create(ForgeRegistries.CONTAINERS, UMUMod.MODID);

	public static final RegistryObject<ContainerType<BackpackContainer>> BACKPACK = CONTAINER.register("backpack", () -> IForgeContainerType.create(BackpackContainer::new));
	public static final RegistryObject<ContainerType<BelongingsUMUPlayerContainer>> BELONGING_INVENTORY = CONTAINER.register("belonging_inventory", () -> IForgeContainerType.create(BelongingsUMUPlayerContainer::new));
}

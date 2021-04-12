package io.github.zemelua.umumod.item;

import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.block.UMUBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UMUItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UMUMod.MODID);

	public static final RegistryObject<Item> WHITE_PLANKS = ITEMS.register("white_planks", () -> new BlockItem(UMUBlocks.WHITE_PLANKS.get(), new Item.Properties().group(ItemGroup.COMBAT)));
}

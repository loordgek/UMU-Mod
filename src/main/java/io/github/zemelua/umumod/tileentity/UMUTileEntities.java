package io.github.zemelua.umumod.tileentity;

import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.block.UMUBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UMUTileEntities {
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, UMUMod.MODID);

	public static final RegistryObject<TileEntityType<WoodenBoxTileEntity>> WOODEN_BOX = TILE_ENTITY.register("wooden_box", () -> TileEntityType.Builder.create(WoodenBoxTileEntity::new, UMUBlocks.WOODEN_BOX.get()).build(null));
}

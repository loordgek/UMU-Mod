package io.github.zemelua.umumod.tileentity;

import io.github.zemelua.umumod.UMUMod;
import io.github.zemelua.umumod.block.UMUBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("ConstantConditions")
public class UMUTileEntities {
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, UMUMod.MODID);

	public static final RegistryObject<TileEntityType<WoodenBoxTileEntityOld>> WOODEN_BOX_OLD = TILE_ENTITY.register("wooden_box_old", () -> TileEntityType.Builder.create(WoodenBoxTileEntityOld::new, UMUBlocks.WOODEN_BOX_OLD.get()).build(null));
	public static final RegistryObject<TileEntityType<WoodenBoxTileEntity>> WOODEN_BOX = TILE_ENTITY.register("wooden_box", () -> TileEntityType.Builder.create(WoodenBoxTileEntity::new, UMUBlocks.WOODEN_BOX.get()).build(null));
	public static final RegistryObject<TileEntityType<ThinWoodenBoxTileEntity>> THIN_WOODEN_BOX = TILE_ENTITY.register("thin_wooden_box", () -> TileEntityType.Builder.create(ThinWoodenBoxTileEntity::new, UMUBlocks.THIN_WOODEN_BOX.get()).build(null));
}

package io.github.zemelua.umumod.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.github.zemelua.umumod.block.blockstateproperty.UMUBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ToolItem;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Set;

public class HammerItem extends ToolItem {
	private static final Set<Material> EFFECTIVE_ON_MATERIALS = new ImmutableSet.Builder<Material>()
			.add(Material.GLASS)
			.add(Material.ICE)
			.add(Material.PACKED_ICE)
			.add(Material.REDSTONE_LIGHT)
			.build();
	private static final Set<Block> EFFECTIVE_ON_BLOCKS = new ImmutableSet.Builder<Block>()
			.build();
	private static final Map<Block, Block> BLOCK_CRACKING_MAP = new ImmutableMap.Builder<Block, Block>()
			.put(Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS)
			.put(Blocks.INFESTED_STONE_BRICKS, Blocks.INFESTED_CRACKED_STONE_BRICKS)
			.put(Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS)
			.put(Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS)
			.build();

	public HammerItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builderIn) {
		super(attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON_BLOCKS, builderIn);
	}


	@Override
	@SuppressWarnings("NullableProblems")
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		@Nonnull Material material = state.getMaterial();
		if (EFFECTIVE_ON_MATERIALS.contains(material)) {
			return this.efficiency;
		}

		return super.getDestroySpeed(stack, state);
	}

	@Override
	@SuppressWarnings("NullableProblems")
	public ActionResultType onItemUse(ItemUseContext context) {
		World world = context.getWorld();
		BlockPos blockPos = context.getPos();
		BlockState blockState = world.getBlockState(blockPos);
		PlayerEntity player = context.getPlayer();

		Block crackable = BLOCK_CRACKING_MAP.get(blockState.getBlock());
		final IntegerProperty property = UMUBlockStateProperties.CONNECTION_SWITCH;
		if (crackable != null) {
			world.playSound(player, blockPos, SoundEvents.BLOCK_BAMBOO_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);

			if (!world.isRemote()) {
				world.setBlockState(blockPos, crackable.getDefaultState(), 11);

				if (player != null) {
					context.getItem().damageItem(1, player, (onBreak) -> onBreak.sendBreakAnimation(context.getHand()));
				}
			}

			return ActionResultType.func_233537_a_(world.isRemote());
		} else if (blockState.hasProperty(property)) {
			world.playSound(player, blockPos, SoundEvents.ENTITY_ITEM_FRAME_ROTATE_ITEM, SoundCategory.BLOCKS, 1.0F, 1.0F);

			if (!world.isRemote()) {
				int index = blockState.get(property);
				index = index != 3 ? index + 1 : 0;
				world.setBlockState(blockPos, blockState.with(property, index), 11);

				if (player != null) {
					context.getItem().damageItem(1, player, (onBreak) -> onBreak.sendBreakAnimation(context.getHand()));
				}
			}


			return ActionResultType.func_233537_a_(world.isRemote());
		}

		return ActionResultType.PASS;
	}
}

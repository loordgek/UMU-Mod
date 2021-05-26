package io.github.zemelua.umumod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.event.world.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlanterBlock extends Block {
	public PlanterBlock(Properties properties) {
		super(properties);
	}

	@Override
	@SuppressWarnings({"NullableProblems", "RedundantIfStatement"})
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
		if (plantable.getPlantType(world, pos) == PlantType.PLAINS) {
			return true;
		}

		return false;
	}

	@SubscribeEvent
	public void onGrowSapling(final SaplingGrowTreeEvent event) {
		if (event.getWorld().getBlockState(event.getPos().down()).getBlock() == this) {
			event.setResult(Event.Result.DENY);
		}
	}
}

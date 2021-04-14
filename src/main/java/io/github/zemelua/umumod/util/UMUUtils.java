package io.github.zemelua.umumod.util;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class UMUUtils {
	public static BlockState[] getAroundFaces(IBlockReader world, BlockPos pos, Direction face) {
		BlockState[] faces = new BlockState[8];
		switch (face) {
			case DOWN: {
				faces[0] = world.getBlockState(pos.south());
				faces[1] = world.getBlockState(pos.south().east());
				faces[2] = world.getBlockState(pos.east());
				faces[3] = world.getBlockState(pos.east().north());
				faces[4] = world.getBlockState(pos.north());
				faces[5] = world.getBlockState(pos.north().west());
				faces[6] = world.getBlockState(pos.west());
				faces[7] = world.getBlockState(pos.west().south());
				break;
			}
			case UP: {
				faces[0] = world.getBlockState(pos.north());
				faces[1] = world.getBlockState(pos.north().east());
				faces[2] = world.getBlockState(pos.east());
				faces[3] = world.getBlockState(pos.east().south());
				faces[4] = world.getBlockState(pos.south());
				faces[5] = world.getBlockState(pos.south().west());
				faces[6] = world.getBlockState(pos.west());
				faces[7] = world.getBlockState(pos.west().north());
				break;
			}
			case NORTH: {
				faces[0] = world.getBlockState(pos.up());
				faces[1] = world.getBlockState(pos.up().west());
				faces[2] = world.getBlockState(pos.west());
				faces[3] = world.getBlockState(pos.west().down());
				faces[4] = world.getBlockState(pos.down());
				faces[5] = world.getBlockState(pos.down().east());
				faces[6] = world.getBlockState(pos.east());
				faces[7] = world.getBlockState(pos.east().up());
				break;
			}
			case SOUTH: {
				faces[0] = world.getBlockState(pos.up());
				faces[1] = world.getBlockState(pos.up().east());
				faces[2] = world.getBlockState(pos.east());
				faces[3] = world.getBlockState(pos.east().down());
				faces[4] = world.getBlockState(pos.down());
				faces[5] = world.getBlockState(pos.down().west());
				faces[6] = world.getBlockState(pos.west());
				faces[7] = world.getBlockState(pos.west().up());
				break;
			}
			case WEST: {
				faces[0] = world.getBlockState(pos.up());
				faces[1] = world.getBlockState(pos.up().south());
				faces[2] = world.getBlockState(pos.south());
				faces[3] = world.getBlockState(pos.south().down());
				faces[4] = world.getBlockState(pos.down());
				faces[5] = world.getBlockState(pos.down().north());
				faces[6] = world.getBlockState(pos.north());
				faces[7] = world.getBlockState(pos.north().up());
				break;
			}
			case EAST: {
				faces[0] = world.getBlockState(pos.up());
				faces[1] = world.getBlockState(pos.up().north());
				faces[2] = world.getBlockState(pos.north());
				faces[3] = world.getBlockState(pos.north().down());
				faces[4] = world.getBlockState(pos.down());
				faces[5] = world.getBlockState(pos.down().south());
				faces[6] = world.getBlockState(pos.south());
				faces[7] = world.getBlockState(pos.south().up());
				break;
			}
		}
		return faces;
	}
}

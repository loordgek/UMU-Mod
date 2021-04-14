package io.github.zemelua.umumod.client.renderer.model;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class ConnectionData {
	private final IBlockReader world;
	private final BlockPos pos;

	public ConnectionData(IBlockReader world, BlockPos pos) {
		this.world = world;
		this.pos = pos;
	}

	public IBlockReader getWorld() {
		return world;
	}

	public BlockPos getPos() {
		return pos;
	}
}

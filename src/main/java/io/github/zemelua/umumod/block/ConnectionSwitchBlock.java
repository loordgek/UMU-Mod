package io.github.zemelua.umumod.block;

import io.github.zemelua.umumod.block.blockstateproperty.UMUBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;

public class ConnectionSwitchBlock extends Block {
	public static final IntegerProperty SWITCH = UMUBlockStateProperties.CONNECTION_SWITCH;

	public ConnectionSwitchBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.getDefaultState().with(SWITCH, 0));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(SWITCH);
	}
}

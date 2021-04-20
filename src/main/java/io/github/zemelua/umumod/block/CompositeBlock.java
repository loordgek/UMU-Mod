package io.github.zemelua.umumod.block;

import net.minecraft.block.Block;

public class CompositeBlock extends Block {
	public CompositeBlock(Properties properties) {
		super(properties);
	}
	/*
	protected final List<Vector3i> PARTS;
	protected final IntegerProperty PART;

	public CompositeBlock(Properties properties, List<Vector3i> parts) {
		super(properties);
		this.PARTS = new ArrayList<>(parts);
		if (!PARTS.contains(new Vector3i(0, 0, 0))) {
			PARTS.add(new Vector3i(0, 0, 0));
		}
		this.PART = IntegerProperty.create("part", 0, parts.size() - 1);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockPos = context.getPos();
		Direction face = context.getPlacementHorizontalFacing().getOpposite();
		World world = context.getWorld();
		if (this.getParts(blockPos).stream().map(i -> i.getY()).max(Integer::compareTo).get() <= 255
				&& !this.map((reader, pos) -> reader.getBlockState(pos).isReplaceable(context), world, blockPos).contains(false)
		) {
			return
		}
	}

	public List<BlockPos> getParts(BlockPos pos) {
		List<BlockPos> parts = new ArrayList<>();
		for (Vector3i index : PARTS) {
			parts.add(pos.south(index.getX()).up(index.getY()).east(index.getZ()));
		}
		return parts;
	}

	public <T> void forEach(BiConsumer<IBlockReader, BlockPos> cons, IBlockReader world, BlockPos pos) {
		for (BlockPos blockPos : this.getParts(pos)) {
			if (!blockPos.equals(new BlockPos(0, 0, 0))) {
				cons.accept(world, blockPos);
			}
		}
	}

	public <R> List<R> map(BiFunction<IBlockReader, BlockPos, R> func, IBlockReader world, BlockPos pos) {
		List<R> list = new ArrayList<>();
		for (BlockPos blockPos : this.getParts(pos)) {
			if (!blockPos.equals(new BlockPos(0, 0, 0))) {
				list.add(func.apply(world, blockPos));
			}
		}
		return list;
	}

	public static final List<Vector3i> CUBE_2x2 = new ArrayList<>(Arrays.asList(
			new Vector3i(0, 0, 1), new Vector3i(0, 1, 0),
			new Vector3i(0, 1, 1), new Vector3i(1, 0, 0),
			new Vector3i(1, 0, 1), new Vector3i(1, 1, 0),
			new Vector3i(1, 1, 1)
	));

	 */
}

package io.github.zemelua.umumod.inventory.container;

import com.google.common.collect.Lists;
import io.github.zemelua.umumod.inventory.container.element.tank.Tank;
import io.github.zemelua.umumod.util.UMUFluidUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidTank;

import javax.annotation.Nullable;
import java.util.List;

public abstract class HasTankContainer extends Container {
	private final List<Tank> inventoryTanks = Lists.newArrayList();
	private final NonNullList<FluidTank> inventoryFluidTanks = NonNullList.create();

	protected HasTankContainer(@Nullable ContainerType<?> type, int id) {
		super(type, id);
	}

	public List<Tank> getInventoryTanks() {
		return inventoryTanks;
	}

	protected Tank addTank(Tank tank) {
		tank.setTankNumber(this.inventoryTanks.size());
		this.inventoryTanks.add(tank);
		this.inventoryFluidTanks.add(UMUFluidUtil.emptyTank());
		return tank;
	}

	public NonNullList<FluidStack> getInventoryFluids() {
		NonNullList<FluidStack> nonNullList = NonNullList.create();

		for (int i = 0; i < this.inventoryTanks.size(); ++i) {
			nonNullList.add(this.inventoryTanks.get(i).getStack());
		}

		return nonNullList;
	}

	protected FluidStack tankClick(int tankId, int dragType, ClickType clickType, PlayerEntity player) {
		FluidStack fluidStack = FluidStack.EMPTY;
		ItemStack itemStack = player.inventory.getItemStack();
		if (clickType == ClickType.PICKUP) {
			if (UMUFluidUtil.getFluidForItemStack(itemStack).isEmpty()) {
				UMUFluidUtil.scoopFluidForTank(itemStack, this.inventoryTanks.get(tankId).getTank());
			} else {
				UMUFluidUtil.pourFluidToTank(itemStack, this.inventoryTanks.get(tankId).getTank());
			}
		} else if (clickType == ClickType.QUICK_MOVE) {

		}

		return fluidStack;
	}

	// protected ItemStack
}

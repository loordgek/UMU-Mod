package io.github.zemelua.umumod.capability;

import net.minecraft.nbt.INBT;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public interface ICachedCapabilitySerializable<C, T extends INBT> extends ICapabilitySerializable<T> {
	public C getCachedContents();
}

package io.github.zemelua.umumod.capability;

import net.minecraft.nbt.INBT;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public interface ICachedCapabilitySerializable<V, T extends INBT> extends ICapabilitySerializable<T> {
	public V getCachedValue();
}

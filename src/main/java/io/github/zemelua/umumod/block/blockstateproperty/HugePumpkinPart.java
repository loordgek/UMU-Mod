package io.github.zemelua.umumod.block.blockstateproperty;

import net.minecraft.util.IStringSerializable;

public enum HugePumpkinPart implements IStringSerializable {
    UPPER_FRONT_RIGHT("upper_front_right"),
    UPPER_FRONT_LEFT ("upper_front_left"),
    UPPER_BACK_RIGHT ("upper_back_right"),
    UPPER_BACK_LEFT  ("upper_back_left"),
    LOWER_FRONT_RIGHT("lower_front_right"),
    LOWER_FRONT_LEFT ("lower_front_left"),
    LOWER_BACK_RIGHT ("lower_back_right"),
    LOWER_BACK_LEFT  ("lower_back_left")
    ;

    private String name;

    private HugePumpkinPart(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getString();
    }

    @Override
    public String getString() {
        return this.name;
    }
}

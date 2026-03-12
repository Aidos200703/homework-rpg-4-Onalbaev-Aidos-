package com.narxoz.rpg.bridge;

public class IceEffect implements EffectImplementor {
    @Override
    public int computeDamage(int basePower) {
        return basePower + 10;
    }

    @Override
    public String getEffectName() {
        return "Ice";
    }
}

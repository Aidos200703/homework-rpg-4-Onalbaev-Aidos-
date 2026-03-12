package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

public class AreaSkill extends Skill {
    public AreaSkill(String name, int power, EffectImplementor effect) {
        super(name, power, effect);
    }

    @Override
    public void cast(CombatNode target) {
        int totalDamage = effect.computeDamage(basePower);
        target.takeDamage(totalDamage); // Composite зақымды іштей таратады
    }
}

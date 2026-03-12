package com.narxoz.rpg.battle;

import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.CombatNode;
import java.util.Random;

public class RaidEngine {
    private Random random = new Random(1L);

    public RaidEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public RaidResult runRaid(CombatNode teamA, CombatNode teamB, Skill skillA, Skill skillB) {
        if (teamA == null || teamB == null) throw new IllegalArgumentException("Teams cannot be null");

        RaidResult result = new RaidResult();
        int round = 0;

        while (teamA.isAlive() && teamB.isAlive() && round < 20) {
            round++;
            result.addLine("--- Round " + round + " ---");

            skillA.cast(teamB);
            result.addLine(teamA.getName() + " uses " + skillA.getSkillName() + " on " + teamB.getName());

            if (teamB.isAlive()) {
                skillB.cast(teamA);
                result.addLine(teamB.getName() + " uses " + skillB.getSkillName() + " on " + teamA.getName());
            }
        }

        result.setRounds(round);
        result.setWinner(teamA.isAlive() ? teamA.getName() : (teamB.isAlive() ? teamB.getName() : "Draw"));
        return result;
    }
}

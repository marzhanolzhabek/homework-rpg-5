package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;
import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }
    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int round = 0;
        int maxRounds = 15;

        result.addLine("--- Battle Log Started ---");

        while (hero.isAlive() && boss.isAlive() && round < maxRounds) {
            round++;
            result.addLine("\nROUND " + round + ":");

            int heroDmg = action.getDamage();
            boss.takeDamage(heroDmg);
            result.addLine("  > " + hero.getName() + " performs " + action.getActionName() +
                    " dealing " + heroDmg + " damage. (Effects: " + action.getEffectSummary() + ")");

            if (!boss.isAlive()) {
                result.addLine("  ! Victory! " + boss.getName() + " has been slain.");
                break;
            }

            int bossDmg = boss.getAttackPower();
            hero.takeDamage(bossDmg);
            result.addLine("  < " + boss.getName() + " counter-attacks for " + bossDmg + " damage.");

            if (!hero.isAlive()) {
                result.addLine("  ! Defeat... " + hero.getName() + " has fallen in battle.");
                break;
            }
        }

        result.setRounds(round);
        result.setWinner(hero.isAlive() ? hero.getName() : boss.getName());
        result.addLine("\n--- Battle End ---");

        return result;
    }
}
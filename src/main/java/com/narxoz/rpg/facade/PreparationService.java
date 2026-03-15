package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class PreparationService {
    public String prepare(HeroProfile hero, BossEnemy boss, AttackAction action) {
        if (hero == null || boss == null || action == null) {
            return "CRITICAL ERROR: Preparation failed. One or more combat participants are missing!";
        }

        StringBuilder summary = new StringBuilder();
        summary.append("[PREP] Hero: ").append(hero.getName()).append(" (HP: ").append(hero.getHealth()).append(")\n");
        summary.append("[PREP] Boss: ").append(boss.getName()).append(" (HP: ").append(boss.getHealth()).append(")\n");
        summary.append("[PREP] Strategy: ").append(action.getActionName()).append(" is ready to be used.");

        return summary.toString();
    }
}
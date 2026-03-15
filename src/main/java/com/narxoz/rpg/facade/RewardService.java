package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null || battleResult.getWinner() == null) {
            return "No reward for invalid journey.";
        }

        String winner = battleResult.getWinner();

        if (!winner.toLowerCase().contains("boss") && !winner.equals("TODO Boss")) {
            int rounds = battleResult.getRounds();

            if (rounds <= 2) {
                return "SSS-Rank: Ancient Dragon Blade";
            } else if (rounds <= 5) {
                return "A-Rank: Knight's Gold Shield";
            } else {
                return "B-Rank: Potion of Health";
            }
        }
        return "Consolation: 1 Silver Coin (Try upgrading your gear!)";
    }
}
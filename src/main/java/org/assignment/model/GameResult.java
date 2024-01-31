package org.assignment.model;

import java.util.List;
import java.util.Map;

public class GameResult {
    private GameMatrix matrix;
    private double reward;
    private Map<String, List<String>> appliedWinningCombinations;
    private String appliedBonusSymbol;

    public GameResult(GameMatrix matrix, double reward, Map<String, List<WinCombination>> winningCombinations, Object o) {
    }

    public GameMatrix getMatrix() {
        return matrix;
    }

    public double getReward() {
        return reward;
    }

    public Map<String, List<String>> getAppliedWinningCombinations() {
        return appliedWinningCombinations;
    }

    public String getAppliedBonusSymbol() {
        return appliedBonusSymbol;
    }

}

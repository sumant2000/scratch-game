package org.assignment.service;

import org.assignment.model.*;
import org.assignment.util.Configuration;

import java.util.*;

public class GameService {
    private Configuration configuration;

    public GameService(Configuration configuration) {
        this.configuration = configuration;
    }

    public GameResult playGame(double betAmount, GameMatrix matrix) {
        Map<String, List<WinCombination>> winningCombinations = checkForWinningCombinations(matrix);
        double reward = calculateReward(betAmount, matrix, winningCombinations);

        // Construct and return a GameResult object
        return new GameResult(matrix, reward, winningCombinations, null);
    }

    public double calculateReward(double betAmount, GameMatrix matrix, Map<String, List<WinCombination>> winningCombinations) {
        double reward = 0;
        for (Map.Entry<String, List<WinCombination>> entry : winningCombinations.entrySet()) {
            String symbol = entry.getKey();
            List<WinCombination> combinations = entry.getValue();
            for (WinCombination winComb : combinations) {
                double symbolRewardMultiplier = configuration.getSymbols().get(symbol).getRewardMultiplier();
                reward += betAmount * symbolRewardMultiplier * winComb.getRewardMultiplier();
            }
        }

        return reward;
    }

    private Map<String, List<WinCombination>> checkForWinningCombinations(GameMatrix matrix) {
        Map<String, List<WinCombination>> winningCombinations = new HashMap<>();
        return winningCombinations;
    }

    public  static GameMatrix createFixedMatrix() {
        // Creating a fixed matrix based on the given input
        List<List<MatrixCell>> rows = Arrays.asList(
                Arrays.asList(new MatrixCell(new Symbol("A")), new MatrixCell(new Symbol("B")), new MatrixCell(new Symbol("C"))),
                Arrays.asList(new MatrixCell(new Symbol("E")), new MatrixCell(new Symbol("B")), new MatrixCell(new Symbol("5x"))),
                Arrays.asList(new MatrixCell(new Symbol("F")), new MatrixCell(new Symbol("D")), new MatrixCell(new Symbol("C")))
        );

        return new GameMatrix(rows);
    }


}

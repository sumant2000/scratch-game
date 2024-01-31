package org.assignment;

import org.assignment.model.*;
import org.assignment.service.GameService;
import org.assignment.util.Configuration;
import org.assignment.util.JsonUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Load configuration
        Configuration config = JsonUtil.loadConfiguration("src/main/resources/config.json");
        if (config == null) {
            System.err.println("Failed to load configuration.");
            return;
        }


        // Initialize the game service
        GameService gameService = new GameService(config);

        // Set a betting amount
        double betAmount = 100.0;

        // Create a fixed game matrix
        GameMatrix matrix = GameService.createFixedMatrix();

        // Play the game with the fixed matrix
        GameResult result = gameService.playGame(betAmount, matrix);

        // Display the results
        displayGameResult(result);
    }

    private static void displayGameResult(GameResult result) {
        if (result == null) {
            System.out.println("No game result to display.");
            return;
        }

        System.out.println("Game Matrix:");
        GameMatrix matrix = result.getMatrix();
        if (matrix == null || matrix.getMatrix() == null) {
            System.out.println("No game matrix available.");
        } else {
            for (List<MatrixCell> row : matrix.getMatrix()) {
                if (row != null) {
                    for (MatrixCell cell : row) {
                        if (cell != null && cell.getSymbol() != null) {
                            System.out.print(cell.getSymbol().getName() + " ");
                        } else {
                            System.out.print("Empty ");
                        }
                    }
                    System.out.println();
                }
            }
        }

        System.out.println("Reward: " + result.getReward());

        System.out.println("Winning Combinations:");
        if (result.getAppliedWinningCombinations() != null) {
            result.getAppliedWinningCombinations().forEach((symbol, combinations) -> {
                System.out.println("Symbol: " + symbol);
                combinations.forEach(combination -> System.out.println(" - " + combination));
            });
        } else {
            System.out.println("No winning combinations.");
        }

        System.out.println("Bonus Symbol: " + (result.getAppliedBonusSymbol() != null ? result.getAppliedBonusSymbol() : "None"));
    }

}

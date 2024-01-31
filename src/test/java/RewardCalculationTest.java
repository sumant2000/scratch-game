import static org.junit.Assert.*;

import org.assignment.model.GameMatrix;
import org.assignment.model.WinCombination;
import org.junit.Test;
import org.assignment.service.GameService;
import org.assignment.util.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RewardCalculationTest {

    @Test
    public void testRewardCalculation() throws IOException {
        Configuration config = new Configuration();
        GameService gameService = new GameService(config);

        // Example betting amount
        double betAmount = 100.0;

        // Create a game matrix for the test (this should match your game's logic)
        GameMatrix matrix = GameService.createFixedMatrix(); // or create a custom matrix for the test

        // Create a map of winning combinations for the test
        Map<String, List<WinCombination>> winningCombinations = new HashMap<>();
        // Populate winningCombinations map as per your game's logic

        // Now, call calculateReward with these test parameters
        double actualReward = gameService.calculateReward(betAmount, matrix, winningCombinations);

        double expectedReward = 100; // Set the expected reward based on your test scenario
        assertEquals("Reward should match expected value", expectedReward, actualReward, 0.01);
    }

}

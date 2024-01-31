import static org.junit.Assert.*;
import org.junit.Test;
import org.assignment.model.*;
import org.assignment.service.GameService;
import org.assignment.util.Configuration;

public class GameServiceTest {

    @Test
    public void testPlayGame() {
        try {
            Configuration config = new Configuration();
            GameService gameService = new GameService(config);

            // Assuming createFixedMatrix() creates a predefined matrix
            GameMatrix matrix = GameService.createFixedMatrix();
            GameResult result = gameService.playGame(100.0, matrix);

            assertNotNull("Result should not be null", result);
        } catch (Exception e) {
            fail("Failed to play game: " + e.getMessage());
        }
    }
}

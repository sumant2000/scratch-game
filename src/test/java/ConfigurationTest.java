import static org.junit.Assert.*;
import org.junit.Test;
import org.assignment.util.Configuration;

public class ConfigurationTest {

    @Test
    public void testConfigurationLoading() {
        try {
            Configuration config = new Configuration();
            assertNotNull("Configuration should not be null", config);
        } catch (Exception e) {
            fail("Failed to load configuration: " + e.getMessage());
        }
    }
}

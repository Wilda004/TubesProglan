
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HealthTrackingControllerTest {

    @Test
    void testIsValidInputWithValidInput() {
        HealthTrackingController controller = new HealthTrackingController();
        assertTrue(controller.isValidInput("70"));
    }

    @Test
    void testIsValidInputWithInvalidInput() {
        HealthTrackingController controller = new HealthTrackingController();
        assertFalse(controller.isValidInput("abc"));
    }

    @Test
    void testCalculateBMI() {
        HealthTrackingController controller = new HealthTrackingController();
        double bmi = controller.calculateBMI(70, 1.75);
        assertEquals(22.86, bmi, 0.01);
    }

    @Test
    void testInterpretBMI() {
        HealthTrackingController controller = new HealthTrackingController();
        String interpretation = controller.interpretBMI(18);
        assertEquals("Underweight", interpretation);
    }
}


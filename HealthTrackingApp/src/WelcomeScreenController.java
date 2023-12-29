import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeScreenController {

    @FXML
    private void handleStartButton(ActionEvent event) throws IOException {
        // Load FXML for the health tracking screen
        Parent healthTrackingRoot = FXMLLoader.load(getClass().getResource("HealthTracking.fxml"));

        // Set the stage for the health tracking screen
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Health Tracking App");
        stage.setScene(new Scene(healthTrackingRoot, 300, 250));
        stage.setResizable(false);
        stage.show();
    }
}

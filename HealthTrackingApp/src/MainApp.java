import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load FXML for the welcome screen
        Parent welcomeScreenRoot = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));

        // Set the stage for the welcome screen
        primaryStage.setTitle("Health Tracking App");
        primaryStage.setScene(new Scene(welcomeScreenRoot, 300, 250));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

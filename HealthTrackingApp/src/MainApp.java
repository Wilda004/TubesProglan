import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Kelas aplikasi utama untuk Health Tracking App.
 */
public class MainApp extends Application {

    /**
     * Metode utama untuk memulai aplikasi.
     *
     * @param primaryStage Panggung utama untuk aplikasi.
     * @throws Exception Jika terjadi kesalahan selama startup aplikasi.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Muat FXML untuk layar selamat datang
        Parent welcomeScreenRoot = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));

        // Atur panggung untuk layar selamat datang
        primaryStage.setTitle("Aplikasi Pemantauan Kesehatan");
        primaryStage.setScene(new Scene(welcomeScreenRoot, 300, 250));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Metode utama untuk meluncurkan aplikasi JavaFX.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam aplikasi ini).
     */
    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HealthTrackingApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load FXML
        Parent root = FXMLLoader.load(getClass().getResource("HealthTracking.fxml"));

        // Set the stage
        primaryStage.setTitle("Health Tracking App");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Informal Specification:
        // - Aplikasi pelacakan kesehatan untuk menghitung BMI (Body Mass Index).
        // - Memiliki antarmuka pengguna sederhana dengan input berat dan tinggi badan.
        // - Dibuat dengan JavaFX dan FXML.

        // Code Review:
        // - Kode ini menggunakan pendekatan Model-View-Controller (MVC) dengan file FXML terpisah.
        // - Penamaan kelas dan metode sesuai dengan konvensi Java.

        // Defensive Programming:
        // - Terdapat validasi input untuk memastikan bahwa input berupa angka.

        // Testing:
        // - Pada tahap ini, belum ada pengujian yang dilakukan. Pengujian dapat diperluas dengan mencakup
        //   skenario pengujian untuk kasus valid dan tidak valid.

        // Versioning Control:
        // - Proyek ini belum menggunakan sistem kontrol versi seperti Git. Disarankan untuk menggunakan Git
        //   atau sistem kontrol versi lainnya untuk melacak perubahan.

        // Launch the JavaFX application
        launch(args);
    }
}

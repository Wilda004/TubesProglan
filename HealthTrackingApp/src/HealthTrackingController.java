import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HealthTrackingController {

    @FXML
    private TextField weightInput;

    @FXML
    private TextField heightInput;

    @FXML
    private Label resultLabel;


    @FXML
    private void handleRecordButton(ActionEvent event) {
        // Informal Specification:
        // - Ketika tombol "Record Health Data" ditekan, aplikasi akan menghitung dan menampilkan BMI.

        // Error Correctness:
        // - Jika input berat atau tinggi tidak valid (bukan angka), aplikasi akan menampilkan pesan kesalahan.

        // Code Review:
        // - Metode ini menangani peristiwa dari tombol dan melakukan pemrosesan input.

        // Defensive Programming:
        // - Melakukan validasi input untuk memastikan bahwa input berupa angka.

        // Testing:
        // - Pada tahap ini, belum ada pengujian yang dilakukan. Pengujian dapat diperluas dengan mencakup
        //   skenario pengujian untuk kasus valid dan tidak valid.

        String weightText = weightInput.getText();
        String heightText = heightInput.getText();

        // Validate input
        if (isValidInput(weightText) && isValidInput(heightText)) {
            // Process input and update result label
            double weight = Double.parseDouble(weightText);
            double height = Double.parseDouble(heightText) / 100; // Convert cm to meters

            double bmi = calculateBMI(weight, height);
            resultLabel.setText("BMI: " + bmi + " - " + interpretBMI(bmi));
        } else {
            // Display error message for invalid input
            resultLabel.setText("Error: Masukkan angka!");
        }
    }

    private boolean isValidInput(String input) {
        // Defensive Programming:
        // - Basic validation for numeric input
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double calculateBMI(double weight, double height) {
        // Formal Program Specification with Hoare Triple:
        // - Precondition: weight and height are valid numeric values.
        // - Postcondition: Returns the calculated BMI based on weight and height.

        // Simple BMI calculation
        return weight / (height * height);
    }

    private String interpretBMI(double bmi) {
        // Informal Specification:
        // - Interpretation of BMI categories

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 22.9) {
            return "Normal Weight";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HealthTrackingController {

    @FXML
    private TextField weightInput;

    @FXML
    private TextField heightInput;

    @FXML
    private Label resultLabel;

    /**
     * Menghandle aksi ketika tombol "Record Health Data" ditekan.
     *
     * @param event Aksi yang terjadi, dalam hal ini, ketika tombol ditekan.
     */
    @FXML
    private void handleRecordButton(ActionEvent event) {
        String weightText = weightInput.getText();
        String heightText = heightInput.getText();

        // Validate input
        if (isValidInput(weightText) && isValidInput(heightText)) {
            // Process input and update result label
            double weight = Double.parseDouble(weightText);
            double height = Double.parseDouble(heightText) / 100; // Convert cm to meters

            double bmi = calculateBMI(weight, height);
            String interpretation = interpretBMI(bmi);
            resultLabel.setText("BMI: " + bmi + " - " + interpretation);

            // Save to file
            saveToFile(bmi, interpretation);
        } else {
            // Display error message for invalid input
            resultLabel.setText("Error: Masukkan angka!");
        }
    }

    /**
     * Memeriksa apakah input adalah angka yang valid.
     *
     * @param input String yang akan diperiksa apakah dapat diubah menjadi angka.
     * @return True jika input adalah angka, False jika tidak.
     */
    private boolean isValidInput(String input) {
        // Basic validation for numeric input
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Menghitung BMI berdasarkan berat dan tinggi.
     *
     * @param weight Berat badan dalam kilogram.
     * @param height Tinggi badan dalam meter.
     * @return Indeks Massa Tubuh (BMI) yang dihitung.
     */
    private double calculateBMI(double weight, double height) {
        // Simple BMI calculation
        return weight / (height * height);
    }

    /**
     * Menginterpretasi kategori BMI.
     *
     * @param bmi Indeks Massa Tubuh (BMI).
     * @return Interpretasi kategori BMI.
     */
    private String interpretBMI(double bmi) {
        // Interpretation of BMI categories
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

    /**
     * Menyimpan hasil BMI ke file teks.
     *
     * @param bmi            Indeks Massa Tubuh (BMI).
     * @param interpretation Interpretasi kategori BMI.
     */
    private void saveToFile(double bmi, String interpretation) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("HealthTrackingApp/src/Record.txt", true))) {
            // Append BMI result to the file
            writer.write("BMI: " + bmi + " - " + interpretation + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

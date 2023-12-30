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

        // Validasi input
        if (isValidInput(weightText) && isValidInput(heightText)) {
            // Proses input dan perbarui label hasil
            double weight = Double.parseDouble(weightText);
            double height = Double.parseDouble(heightText) / 100; // Konversi cm ke meter

            double bmi = calculateBMI(weight, height);
            String interpretation = interpretBMI(bmi);
            resultLabel.setText("BMI: " + bmi + " - " + interpretation);

            // Simpan ke file
            saveToFile(bmi, interpretation);
        } else {
            // Tampilkan pesan kesalahan untuk input yang tidak valid
            resultLabel.setText("Error: Masukkan angka!");
        }
    }

    /**
     * Memeriksa apakah input adalah angka yang valid.
     *
     * @param input String yang akan diperiksa apakah dapat diubah menjadi angka.
     * @return True jika input adalah angka, False jika tidak.
     */
    public boolean isValidInput(String input) {
        // Defensive Programming: Validasi dasar untuk input numerik
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false; // Jika input tidak dapat diubah menjadi double, anggap tidak valid
        }
    }

    /**
     * Menghitung BMI berdasarkan berat dan tinggi.
     *
     * @param weight Berat badan dalam kilogram.
     * @param height Tinggi badan dalam meter.
     * @return Indeks Massa Tubuh (BMI) yang dihitung.
     */
    public double calculateBMI(double weight, double height) {
        // Perhitungan BMI sederhana
        return weight / (height * height);
    }

    /**
     * Menginterpretasi kategori BMI.
     *
     * @param bmi Indeks Massa Tubuh (BMI).
     * @return Interpretasi kategori BMI.
     */
    public String interpretBMI(double bmi) {
        // Interpretasi kategori BMI
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
     * @param bmi Indeks Massa Tubuh (BMI).
     * @param interpretation Interpretasi kategori BMI.
     */
    private void saveToFile(double bmi, String interpretation) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("HealthTrackingApp/src/Record.txt", true))) {
            // Tambahkan hasil BMI ke file
            writer.write("BMI: " + bmi + " - " + interpretation + "\n");
        } catch (IOException e) {
            e.printStackTrace(); // Cetak jejak stack jika terjadi IOException
        }
    }
}

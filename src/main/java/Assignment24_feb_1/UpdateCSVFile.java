package Assignment24_feb_1;
import java.io.*;
import java.nio.file.*;

public class UpdateCSVFile {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";
        updateSalaries(inputFile, outputFile);
    }

    public static void updateSalaries(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String header = br.readLine();
            bw.write(header + "\n");

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3]) * 1.1;
                    data[3] = String.format("%.2f", salary);
                }
                bw.write(String.join(",", data) + "\n");
            }
            System.out.println("✅ Updated salaries saved to: " + outputFile);
        } catch (IOException | NumberFormatException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}

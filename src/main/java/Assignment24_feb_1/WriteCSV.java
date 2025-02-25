package Assignment24_feb_1;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("1,John Doe,IT,60000\n");
            writer.append("2,Jane Smith,HR,55000\n");
            writer.append("3,Robert Brown,Finance,70000\n");
            writer.append("4,Emily Davis,Marketing,50000\n");
            writer.append("5,Michael Wilson,Sales,65000\n");

            System.out.println("✅ CSV file created successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }
}

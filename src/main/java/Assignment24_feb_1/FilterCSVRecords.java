package Assignment24_feb_1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSVRecords {
    public static void main(String[] args) {
        String filePath = "students.csv";
        filterRecords(filePath);
    }

    public static void filterRecords(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3]);
                if (marks > 80) {
                    System.out.println("ID: " + data[0] + ", Name: " + data[1] + ", Marks: " + data[3]);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }
}

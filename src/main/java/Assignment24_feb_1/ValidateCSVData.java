package Assignment24_feb_1;
import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        validateCSV(filePath);
    }

    public static void validateCSV(String filePath) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            System.out.println("Checking for invalid rows...");
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 5) {
                    System.out.println("❌ Invalid row (missing columns): " + line);
                    continue;
                }
                Matcher emailMatcher = emailPattern.matcher(data[3]);
                Matcher phoneMatcher = phonePattern.matcher(data[4]);

                if (!emailMatcher.matches()) {
                    System.out.println("❌ Invalid email: " + data[3]);
                }
                if (!phoneMatcher.matches()) {
                    System.out.println("❌ Invalid phone number: " + data[4]);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }
}

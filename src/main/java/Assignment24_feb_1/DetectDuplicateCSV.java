package Assignment24_feb_1;
import java.io.*;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "students.csv";
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!uniqueIds.add(data[0])) {
                    duplicates.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }

        if (duplicates.isEmpty()) {
            System.out.println("✅ No duplicate records found.");
        } else {
            System.out.println("❌ Duplicate records found:");
            duplicates.forEach(System.out::println);
        }
    }
}

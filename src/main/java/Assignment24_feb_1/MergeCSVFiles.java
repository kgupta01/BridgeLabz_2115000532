package Assignment24_feb_1;
import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";
        mergeCSV(file1, file2, outputFile);
    }

    public static void mergeCSV(String file1, String file2, String outputFile) {
        Map<String, String[]> studentData = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            br1.readLine();
            String line;
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentData.put(data[0], data);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading " + file1 + ": " + e.getMessage());
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
            br2.readLine();
            String line;
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                if (studentData.containsKey(data[0])) {
                    String[] student1 = studentData.get(data[0]);
                    studentData.put(data[0], new String[]{student1[0], student1[1], student1[2], data[1], data[2]});
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading " + file2 + ": " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n");
            for (String[] student : studentData.values()) {
                bw.write(String.join(",", student) + "\n");
            }
            System.out.println("✅ Merged file created: " + outputFile);
        } catch (IOException e) {
            System.out.println("❌ Error writing file: " + e.getMessage());
        }
    }
}


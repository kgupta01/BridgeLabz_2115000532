package Assignment24_feb_1;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

    public class ReadCSV {
        public static void main(String[] args) {
            String filePath = "students.csv";
            readCSV(filePath);
        }

        public static void readCSV(String filePath) {
            try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                String[] nextRecord;


                while ((nextRecord = reader.readNext()) != null) {
                    System.out.println("ID: " + nextRecord[0] + ", Name: " + nextRecord[1] +
                            ", Age: " + nextRecord[2] + ", Marks: " + nextRecord[3]);
                }
            } catch (IOException e) {
                System.out.println("❌ Error reading file: " + e.getMessage());
            }
        }
    }

package Assignment24_feb_1;
import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "large_file.csv";
        readCSVInChunks(filePath, 100);
    }

    public static void readCSVInChunks(String filePath, int chunkSize) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                count++;
                if (count % chunkSize == 0) {
                    System.out.println("Processed " + count + " records...");
                }
            }
            System.out.println("Total records processed: " + count);
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }
}


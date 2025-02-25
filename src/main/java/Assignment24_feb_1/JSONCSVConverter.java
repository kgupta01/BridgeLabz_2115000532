package Assignment24_feb_1;
import java.io.*;
import java.util.*;
import org.json.*;

public class JSONCSVConverter {
    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";
        String outputJsonFile = "converted_students.json";

        jsonToCsv(jsonFile, csvFile);
        csvToJson(csvFile, outputJsonFile);
    }

    public static void jsonToCsv(String jsonFile, String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

            StringBuilder jsonData = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonData.append(line);
            }

            JSONArray students = new JSONArray(jsonData.toString());
            bw.write("ID,Name,Age,Marks\n");

            for (int i = 0; i < students.length(); i++) {
                JSONObject obj = students.getJSONObject(i);
                bw.write(obj.getInt("ID") + "," + obj.getString("Name") + "," +
                        obj.getInt("Age") + "," + obj.getDouble("Marks") + "\n");
            }

            System.out.println("✅ JSON converted to CSV: " + csvFile);
        } catch (IOException | JSONException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public static void csvToJson(String csvFile, String jsonFile) {
        JSONArray jsonArray = new JSONArray();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile))) {

            String header = br.readLine();
            String[] columns = header.split(",");
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                JSONObject obj = new JSONObject();
                for (int i = 0; i < columns.length; i++) {
                    if (i == 0 || i == 2) obj.put(columns[i], Integer.parseInt(data[i]));
                    else if (i == 3) obj.put(columns[i], Double.parseDouble(data[i]));
                    else obj.put(columns[i], data[i]);
                }
                jsonArray.put(obj);
            }

            bw.write(jsonArray.toString(4));
            System.out.println("✅ CSV converted to JSON: " + jsonFile);
        } catch (IOException | JSONException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}


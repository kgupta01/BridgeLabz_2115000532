package Assignment24_feb_1;
import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student { ID=" + id + ", Name='" + name + "', Age=" + age + ", Marks=" + marks + " }";
    }
}

public class CSVToObject {
    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> students = readCSV(filePath);
        students.forEach(System.out::println);
    }

    public static List<Student> readCSV(String filePath) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Student student = new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Double.parseDouble(data[3])
                );
                students.add(student);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
        return students;
    }
}

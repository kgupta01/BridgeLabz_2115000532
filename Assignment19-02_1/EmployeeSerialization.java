import java.io.*;
import java.util.*;
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String department;
    double salary;
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}
public class EmployeeSerialization {
    public static void saveEmployees(List<Employee> employees, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public static List<Employee> loadEmployees(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Khushi", "HR", 50000),
                new Employee(2, "Piyush", "IT", 60000),
                new Employee(3, "Aditya", "Finance", 55000)
        );
        String filename = "employees.dat";
        saveEmployees(employees, filename);
        List<Employee> loadedEmployees = loadEmployees(filename);
        System.out.println("Loaded Employees:");
        loadedEmployees.forEach(System.out::println);
    }
}

import java.util.*;
import java.util.stream.Collectors;
class Employee {
    String name;
    String department;
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    @Override
    public String toString() {
        return name;
    }
}
public class GroupByDepartment {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(e -> e.department));
    }
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Khushi", "HR"),
            new Employee("Piyush", "IT"),
            new Employee("Aditya", "HR")
        );       
        Map<String, List<Employee>> grouped = groupByDepartment(employees);
        System.out.println(grouped);
    }
}

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public abstract double calculateSalary();
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }
    public double calculateSalary() {
        return getBaseSalary();
    }
}
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public int getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
interface Department {
    void assignDepartment(String department);
    void getDepartmentDetails();
}
class HRDepartment implements Department {
    public void assignDepartment(String department) {
        System.out.println("Department Assigned: " + department);
    }
    public void getDepartmentDetails() {
        System.out.println("This is the HR department.");
    }
}
public class EmployeeManagement {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee(1, "Khushi", 50000);
        Employee e2 = new PartTimeEmployee(2, "Piyush", 20, 100);
        e1.displayDetails();
        e2.displayDetails();
        Department hr = new HRDepartment();
        hr.assignDepartment("HR");
        hr.getDepartmentDetails();
    }
}

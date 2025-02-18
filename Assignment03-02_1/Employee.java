public class Employee {
    static String companyName = "Capgemini";
    final int id;
    String name;
    String designation;
    static int totalEmployees = 0;
    public Employee(String name, int id , String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
	totalEmployees++;
    }
    public static void displayTotalEmployees() {
        System.out.println("Total No. of Employees: " + totalEmployees);
    }
    public void displayEmployeeDetails() {
            System.out.println("name: " + name);
            System.out.println("id: " + id);
            System.out.println("designation: " + designation);
        
    }
    public static void main(String[] args) {
        Employee e1 = new Employee("Khushi", 1, "Senior Software Developer");
        Employee e2 = new Employee("Piyush", 2, "Junior Software Developer");
	System.out.println(e1 instanceof Employee);
	System.out.println(e2 instanceof Employee);        
	e1.displayEmployeeDetails();
        e2.displayEmployeeDetails();
        Employee.displayTotalEmployees();
    }
}

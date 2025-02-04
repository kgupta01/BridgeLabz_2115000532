public class Student {
    static String universityName = "GLA University";
    static int totalStudents = 0;
    final int rollNumber;
    String name;
    String grade;
    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }
    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("University: " + universityName);
    }
    public static void main(String[] args) {
        Student student1 = new Student(1, "Khushi Gupta", "A+");
        Student student2 = new Student(2, "Piyush Tiwari", "A");   
        student1.displayStudentDetails();
	student2.displayStudentDetails();
	Student.displayTotalStudents();
    }
}

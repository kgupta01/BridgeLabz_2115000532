class Student {
    private String name;
    public Student() {
        this.name = "Default Student";
    }
    public void display() {
        System.out.println("Student Name: " + name);
    }
}
public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Student");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Student student = (Student) obj;
        student.display();
    }
}

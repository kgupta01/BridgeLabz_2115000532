import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}
class Project {
    @Todo(task = "Implement user authentication", assignedTo = "Khushi", priority = "HIGH")
    void loginFeature() {
        System.out.println("Login feature work in progress...");
    }
    @Todo(task = "Optimize database queries", assignedTo = "Piyush")
    void optimizeDB() {
        System.out.println("Database optimization in progress...");
    }
    @Todo(task = "Improve UI responsiveness", assignedTo = "Aditya", priority = "LOW")
    void improveUI() {
        System.out.println("UI improvements ongoing...");
    }
}
public class TodoList {
    public static void main(String[] args) {
        for (Method method : Project.class.getDeclaredMethods()) {
            Todo annotation = method.getAnnotation(Todo.class);
            if (annotation != null) {
                System.out.println("Task: " + annotation.task());
                System.out.println("Assigned To: " + annotation.assignedTo());
                System.out.println("Priority: " + annotation.priority());
                System.out.println();
            }
        }
    }
}

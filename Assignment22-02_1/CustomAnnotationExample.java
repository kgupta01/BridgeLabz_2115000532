import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo {
    String priority();
    String assignedTo();
}
class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Kanhaiya")
    void completeTask() {
        System.out.println("Task completed.");
    }
}
public class CustomAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getDeclaredMethod("completeTask");
        TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
        if (taskInfo != null) {
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}

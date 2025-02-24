import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {
}
class Task {
    @LogExecutionTime
    void fastMethod() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
        System.out.println("Fast method executed.");
    }
    @LogExecutionTime
    void slowMethod() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Slow method executed.");
    }
}
public class LoggingExecutionTime {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        for (Method method : Task.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(task);
                long endTime = System.nanoTime();
                System.out.println("Execution time for " + method.getName() + ": " + (endTime - startTime) / 1_000_000 + " ms\n");
            }
        }
    }
}

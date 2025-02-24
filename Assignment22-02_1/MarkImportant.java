import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}
class Demo {
    @ImportantMethod
    void criticalTask() {
        System.out.println("Executing critical task...");
    }
    @ImportantMethod(level = "MEDIUM")
    void secondaryTask() {
        System.out.println("Executing secondary task...");
    }
    void normalTask() {
        System.out.println("Executing normal task...");
    }
}
public class MarkImportant {
    public static void main(String[] args) {
        for (Method method : Demo.class.getDeclaredMethods()) {
            ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
            if (annotation != null) {
                System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
            }
        }
    }
}

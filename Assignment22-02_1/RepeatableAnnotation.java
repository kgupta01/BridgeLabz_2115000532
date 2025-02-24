import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}
@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}
class Software {
    @BugReport(description = "Null pointer exception occurs on input.")
    @BugReport(description = "Performance issue when handling large data.")
    void process() {
        System.out.println("Processing data...");
    }
}
public class RepeatableAnnotation {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getDeclaredMethod("process");
        BugReports reports = method.getAnnotation(BugReports.class);
        if (reports != null) {
            for (BugReport report : reports.value()) {
                System.out.println("Bug: " + report.description());
            }
        }
    }
}

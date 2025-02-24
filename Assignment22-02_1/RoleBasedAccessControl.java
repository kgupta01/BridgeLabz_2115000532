import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}
class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed.");
    }
}
class User {
    private String role;
    public User(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
public class RoleBasedAccessControl {
    public static void main(String[] args) {
        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");
        SecureService service = new SecureService();
        checkAccessAndExecute(service, "adminTask", adminUser); 
        checkAccessAndExecute(service, "adminTask", normalUser); 
    }
    public static void checkAccessAndExecute(Object obj, String methodName, User user) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
            if (annotation != null && !annotation.value().equals(user.getRole())) {
                System.out.println("Access Denied!");
                return;
            }
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

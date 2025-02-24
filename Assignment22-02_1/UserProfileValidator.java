import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}
class User {
    @MaxLength(10)
    private String username;
    public User(String username) {
        validateMaxLength(username);
        this.username = username;
    }
    private void validateMaxLength(String username) {
        try {
            Field field = User.class.getDeclaredField("username");
            MaxLength annotation = field.getAnnotation(MaxLength.class);
            if (annotation != null && username.length() > annotation.value()) {
                throw new IllegalArgumentException("Username exceeds max length of " + annotation.value() + " characters.");
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public String getUsername() {
        return username;
    }
}
public class UserProfileValidator {
    public static void main(String[] args) {
        try {
            User user1 = new User("Kanhaiya");
            System.out.println("Username: " + user1.getUsername());
            User user2 = new User("VeryLongUsername"); 
            System.out.println("Username: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

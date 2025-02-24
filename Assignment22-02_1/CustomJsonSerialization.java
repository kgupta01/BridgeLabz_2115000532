import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}
class User {
    @JsonField(name = "user_name")
    private String username;
    @JsonField(name = "user_age")
    private int age;
    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                try {
                    json.append("\"").append(annotation.name()).append("\": ");
                    if (field.getType() == String.class) {
                        json.append("\"").append(field.get(obj)).append("\"");
                    } else {
                        json.append(field.get(obj));
                    }
                    json.append(", ");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        if (json.length() > 1) {
            json.setLength(json.length() - 2); 
        }
        json.append("}");
        return json.toString();
    }
}
public class CustomJsonSerialization {
    public static void main(String[] args) {
        User user = new User("Kanhaiya", 22);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}

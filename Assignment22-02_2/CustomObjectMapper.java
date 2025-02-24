import java.lang.reflect.*;
import java.util.*;
class Person {
    private String name;
    private int age;
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj, entry.getValue());
        }
        return obj;
    }
    public static void main(String[] args) throws Exception {
        Map<String, Object> data = Map.of("name", "Kanhaiya", "age", 22);
        Person person = toObject(Person.class, data);
        person.display();
    }
}

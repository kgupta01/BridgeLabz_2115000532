import java.lang.reflect.*;
import java.util.*;
public class ClassInfoRetriever {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();
        scanner.close();
        try {
            Class<?> clazz = Class.forName(className);
            System.out.println("\nClass: " + clazz.getName());
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                System.out.println(constructor);
            }
            System.out.println("\nMethods:");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(method);
            }
            System.out.println("\nFields:");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.println(field);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
}

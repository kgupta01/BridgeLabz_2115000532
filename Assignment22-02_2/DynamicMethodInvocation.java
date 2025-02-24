import java.lang.reflect.*;
import java.util.*;
class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
}
public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();
        System.out.print("Enter two numbers: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.close();
        MathOperations mathOps = new MathOperations();
        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
        int result = (int) method.invoke(mathOps, x, y);
        System.out.println("Result: " + result);
    }
}

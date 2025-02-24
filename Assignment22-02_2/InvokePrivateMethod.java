import java.lang.reflect.*;
class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}
public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        Method method = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(calculator, 5, 4);
        System.out.println("Result: " + result);
    }
}

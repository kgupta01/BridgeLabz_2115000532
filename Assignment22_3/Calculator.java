package Day3_23_01_2025.Level3;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double first, second;
        String op;
        System.out.print("Enter the two number: ");
        first = sc.nextDouble();
        second = sc.nextDouble();
        System.out.print("Enter the operator (+, -, *, /): ");
        op = sc.next();
        double result = 0;
        boolean validOp = true;
        switch (op) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second != 0) {
                    result = first / second;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    validOp= false;
                }
                break;
            default:
                System.out.println("Invalid Operator.");
                validOp= false;
                break;
        }
        if (validOp) {
            System.out.println("Result: " + result);
        }
    }
}

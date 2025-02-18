import java.util.*;
public class ques7 {
    public static int takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
    public static void displayResult(int gcd, int lcm) {
        System.out.println("GCD is: " + gcd);
        System.out.println("LCM is: " + lcm);
    }
    public static void main(String[] args) {
        System.out.println("Enter two numbers:");
        int num1 = takeInput();
        int num2 = takeInput();
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);        
        displayResult(gcd, lcm);
    }
}

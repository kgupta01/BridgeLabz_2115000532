import java.util.*;
public class ques2 {
    public static int sumRecursive(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumRecursive(n - 1);
        }
    }
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a positive natural number.");
            scanner.close();
            return;
        }
        int sumByRecursion = sumRecursive(n);
        int sumByFormula = sumFormula(n);
        System.out.println("Sum of first " + n + " natural numbers (using recursion): " + sumByRecursion);
        System.out.println("Sum of first " + n + " natural numbers (using formula): " + sumByFormula);
        if (sumByRecursion == sumByFormula) {
            System.out.println("Both methods give the correct result!");
        } else {
            System.out.println("There is an error in the computations.");
        }
    }
}

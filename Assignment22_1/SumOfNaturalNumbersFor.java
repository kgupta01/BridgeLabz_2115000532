package D_23_01_25.Level1;

import java.util.Scanner;

public class SumOfNaturalNumbersFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer (natural number): ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("The entered number is not a natural number.");
        } else {
            int sumFormula = n * (n + 1) / 2;
            int sumLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumLoop += i;
            }
            System.out.println("Sum calculated using formula: " + sumFormula);
            System.out.println("Sum calculated using for loop: " + sumLoop);
            if (sumFormula == sumLoop) {
                System.out.println("Both computations match. The result is correct.");
            } else {
                System.out.println("The computations do not match. There is an error.");
            }
        }
    }
}

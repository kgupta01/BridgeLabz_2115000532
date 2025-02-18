import java.util.*;
public class ques8 {
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int[] result = new int[2];
        result[0] = Math.min(number1, Math.min(number2, number3));  // Smallest
        result[1] = Math.max(number1, Math.max(number2, number3));  // Largest
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();
        System.out.print("Enter the third number: ");
        int number3 = scanner.nextInt();
        int[] result = findSmallestAndLargest(number1, number2, number3);
        System.out.println("Smallest number: " + result[0]);
        System.out.println("Largest number: " + result[1]);
    }
}

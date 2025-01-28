import java.util.*;
public class ques9 {
    public static String isPositive(int number) {
        return number >= 0 ? "positive" : "negative";
    }
    public static String isEven(int number) {
        return number % 2 == 0 ? "even" : "odd";
    }
    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        if (num1 < num2) return -1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
            String sign = isPositive(numbers[i]);
            System.out.println("The number is " + sign);
            if (sign.equals("positive")) {
                System.out.println("The number is " + isEven(numbers[i]));
            }
        }
        int comparison = compare(numbers[0], numbers[4]);
        if (comparison == 1) {
            System.out.println("First element is greater than the last element.");
        } else if (comparison == 0) {
            System.out.println("First element is equal to the last element.");
        } else {
            System.out.println("First element is less than the last element.");
        }
    }
}

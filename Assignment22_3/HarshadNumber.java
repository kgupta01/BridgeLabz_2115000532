package Day3_23_01_2025.Level3;
import java.util.Scanner;
public class HarshadNumber {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = ip.nextInt();
        int sum = 0;
        int originalNum = num;
        while (num != 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        if (originalNum % sum == 0) {
            System.out.println(originalNum + " is a Harshad Number.");
        } else {
            System.out.println(originalNum + " is not a Harshad Number.");
        }
    }
}
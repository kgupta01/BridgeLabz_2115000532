package Day3_23_01_2025.Level3;
import java.util.Scanner;
public class AbandonNumber {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = ip.nextInt();
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        if (sum > number) {
            System.out.println(number + " is an Abundant Number.");
        } else {
            System.out.println(number + " is not an Abundant Number.");
        }
    }
}
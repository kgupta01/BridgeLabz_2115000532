package Day3_23_01_2025.Level3;
import java.util.Scanner;
public class Armstrong{
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = ip.nextInt();
        int sum = 0;
        int originalNum = num;
        while (originalNum != 0) {
            int digit = originalNum % 10;
            sum += digit * digit * digit;
            originalNum /= 10;
        }
        if (num == sum)
            System.out.println(num+ " is an Armstrong number.");
        else
            System.out.println(num+ " is not an Armstrong number.");
    }
}

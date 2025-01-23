package Day3_23_01_2025.Level3;
import java.util.Scanner;
public class DigitsOfInteger{
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = ip.nextInt();
        num = Math.abs(num);
        int count = 0;
        if (num == 0) {
            count = 1;
        } else {
            while (num != 0) {
                num /= 10;
                count++;
            }
        }
        System.out.println("Number of digits: " + count);
    }
}
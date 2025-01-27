import java.util.*;
public class ques4 {
    public static int calculateRounds(int side1, int side2, int side3) {
        int perimeter = side1 + side2 + side3;
        return (int) Math.ceil(5000.0 / perimeter);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int side1 = scanner.nextInt();
        int side2 = scanner.nextInt();
        int side3 = scanner.nextInt();
        System.out.println(calculateRounds(side1, side2, side3));
    }
}

import java.util.*;
public class ques2 {
    public static int takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    public static void main(String[] args) {
        System.out.println("Enter three numbers:");
        int num1 = takeInput();
        int num2 = takeInput();
        int num3 = takeInput();        
        int max = findMax(num1, num2, num3);
        System.out.println("The maximum number is: " + max);
    }
}

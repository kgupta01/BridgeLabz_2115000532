import java.util.*;
public class ques6 {
    public static int takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static int calculateFactorial(int number) {
        if (number == 0) return 1;
        return number * calculateFactorial(number - 1);
    }
    public static void displayResult(int result) {
        System.out.println("The factorial is: " + result);
    }
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int number = takeInput();        
        int result = calculateFactorial(number);
        displayResult(result);
    }
}

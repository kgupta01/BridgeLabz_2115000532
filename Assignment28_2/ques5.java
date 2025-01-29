import java.util.*;
public class ques5 {
    public static String takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void displayResult(boolean result) {
        if (result) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter a string:");
        String input = takeInput();        
        boolean result = isPalindrome(input);
        displayResult(result);
    }
}

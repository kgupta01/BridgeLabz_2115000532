import java.util.*;
public class ques6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = scanner.nextLine();
        System.out.println("Enter the substring: ");
        String substring = scanner.nextLine();
        int count = 0;
        for (int i = 0; i <= str.length() - substring.length(); i++) {
            if (str.substring(i, i + substring.length()).equals(substring)) {
                count++;
            }
        }
        System.out.println("Substring occurs " + count + " times.");
    }
}

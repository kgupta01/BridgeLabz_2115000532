import java.util.*;
public class ques10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();
        System.out.println("Enter character to remove: ");
        char ch = scanner.next().charAt(0);
        String result = str.replaceAll(String.valueOf(ch), "");        
        System.out.println("Modified String: " + result);
    }
}

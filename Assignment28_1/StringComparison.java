import java.util.*;
public class ques8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.println("Enter second string: ");
        String str2 = scanner.nextLine();
        int minLength = Math.min(str1.length(), str2.length());
        int result = 0;
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                result = -1;
                break;
            } else if (str1.charAt(i) > str2.charAt(i)) {
                result = 1;
                break;
            }
        }
        if (result == 0) {
            if (str1.length() < str2.length()) {
                result = -1;
            } else if (str1.length() > str2.length()) {
                result = 1;
            }
        }
        if (result == -1) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else if (result == 1) {
            System.out.println("\"" + str1 + "\" comes after \"" + str2 + "\" in lexicographical order");
        } else {
            System.out.println("\"" + str1 + "\" is equal to \"" + str2 + "\"");
        }
    }
}

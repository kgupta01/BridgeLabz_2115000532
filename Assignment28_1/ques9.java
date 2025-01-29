import java.util.*;
public class ques9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();
        int[] freq = new int[256];
        int maxCount = 0;
        char maxChar = '\0';
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
            if (freq[ch] > maxCount) {
                maxCount = freq[ch];
                maxChar = ch;
            }
        }
        System.out.println("Most Frequent Character: '" + maxChar + "'");
    }
}

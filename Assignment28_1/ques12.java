import java.util.*;
public class ques12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = scanner.nextLine();
        System.out.println("Enter word to replace: ");
        String oldWord = scanner.nextLine();
        System.out.println("Enter replacement word: ");
        String newWord = scanner.nextLine();
        String result = sentence.replace(oldWord, newWord);        
        System.out.println("Modified sentence: " + result);
    }
}

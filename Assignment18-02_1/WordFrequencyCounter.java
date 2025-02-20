import java.io.*;
import java.util.*;
public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        Scanner scanner = new Scanner(file);
        Map<String, Integer> wordCount = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next().replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        scanner.close();       
        System.out.println(wordCount);
    }
}

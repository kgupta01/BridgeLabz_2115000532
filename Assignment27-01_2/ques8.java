import java.util.*;
public class ques8 {
    public static String findYoungest(int[] ages) {
        int minAge = ages[0];
        String friend = "Amar";
        if (ages[1] < minAge) {
            minAge = ages[1];
            friend = "Akbar";
        }
        if (ages[2] < minAge) {
            minAge = ages[2];
            friend = "Anthony";
        }
        return friend;
    }
    public static String findTallest(int[] heights) {
        int maxHeight = heights[0];
        String friend = "Amar";
        if (heights[1] > maxHeight) {
            maxHeight = heights[1];
            friend = "Akbar";
        }
        if (heights[2] > maxHeight) {
            maxHeight = heights[2];
            friend = "Anthony";
        }
        return friend;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];
        System.out.print("Enter age of Amar: ");
        ages[0] = scanner.nextInt();
        System.out.print("Enter height of Amar: ");
        heights[0] = scanner.nextInt();
        System.out.print("Enter age of Akbar: ");
        ages[1] = scanner.nextInt();
        System.out.print("Enter height of Akbar: ");
        heights[1] = scanner.nextInt();
        System.out.print("Enter age of Anthony: ");
        ages[2] = scanner.nextInt();
        System.out.print("Enter height of Anthony: ");
        heights[2] = scanner.nextInt();
        System.out.println("Youngest friend: " + findYoungest(ages));
        System.out.println("Tallest friend: " + findTallest(heights));
    }
}

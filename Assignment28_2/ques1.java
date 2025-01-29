import java.util.*;
public class ques1 {
    public static int generateGuess(int lower, int upper) {
        Random rand = new Random();
        return rand.nextInt(upper - lower + 1) + lower;
    }
    public static String getFeedback() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is the guess too high, too low, or correct?");
        return scanner.nextLine();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lower = 1, upper = 100;
        String feedback;
        System.out.println("Think of a number between 1 and 100.");
        while (true) {
            int guess = generateGuess(lower, upper);
            System.out.println("Computer guesses: " + guess);
            feedback = getFeedback();            
            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Yay! The computer guessed your number.");
                break;
            } else if (feedback.equalsIgnoreCase("too low")) {
                lower = guess + 1;
            } else if (feedback.equalsIgnoreCase("too high")) {
                upper = guess - 1;
            }
        }
    }
}

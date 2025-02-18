import java.util.*;
public class ques12 {
    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = (int)(Math.random() * 90) + 10; // Physics score (10-99)
            scores[i][1] = (int)(Math.random() * 90) + 10; // Chemistry score (10-99)
            scores[i][2] = (int)(Math.random() * 90) + 10; // Math score (10-99)
        }
        return scores;
    }
    public static double[][] calculateTotalAveragePercentage(int[][] scores) {
        double[][] result = new double[scores.length][4];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }
    public static void displayScorecard(int[][] scores, double[][] result) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.2f\t%.2f\t%.2f%%\n",
                i + 1, scores[i][0], scores[i][1], scores[i][2],
                result[i][0], result[i][1], result[i][2]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        int[][] scores = generateScores(numStudents);
        double[][] result = calculateTotalAveragePercentage(scores);
        displayScorecard(scores, result);
    }
}

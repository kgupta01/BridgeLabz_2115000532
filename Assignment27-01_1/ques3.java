import java.util.*;
public class ques3 {
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = scanner.nextInt();
        System.out.println(calculateHandshakes(numberOfStudents));
    }
}

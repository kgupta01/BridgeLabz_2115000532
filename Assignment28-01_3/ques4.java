import java.time.LocalDate;
import java.util.*;
public class ques4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first date (yyyy-mm-dd):");
        String date1 = scanner.nextLine();
        System.out.println("Enter second date (yyyy-mm-dd):");
        String date2 = scanner.nextLine();
        LocalDate firstDate = LocalDate.parse(date1);
        LocalDate secondDate = LocalDate.parse(date2);        
        if (firstDate.isBefore(secondDate)) {
            System.out.println("The first date is before the second date.");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("The first date is after the second date.");
        } else {
            System.out.println("The first date is the same as the second date.");
        }
    }
}

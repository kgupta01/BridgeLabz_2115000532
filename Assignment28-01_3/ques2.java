import java.time.LocalDate;
import java.util.*;
public class ques2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a date (yyyy-mm-dd):");
        String inputDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(inputDate);
        LocalDate resultDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);        
        System.out.println("Resulting date: " + resultDate);
    }
}

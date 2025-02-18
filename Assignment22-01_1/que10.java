import java.util.*;
public class que10{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
double total = sc.nextInt();
 while (true) {
            
            System.out.print("Enter a number (or 0 to stop): ");
            double userInput = sc.nextDouble();
            
            
            if (userInput == 0) {
                break;
            }
total += userInput;}
  System.out.println("The total sum is: " + total);

}

}

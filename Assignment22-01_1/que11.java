import java.util.Scanner;

public class que11 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        
        double total = 0.0;
        
        
        for (;;) {
            
            System.out.print("Enter a number (or 0 or negative number to stop): ");
            double userInput = scanner.nextDouble();
            
          
            if (userInput <= 0) {
                break; 
            }
            
total += userInput;
        }
        
System.out.println("The total sum is: " + total);
        
        
      
    }
}

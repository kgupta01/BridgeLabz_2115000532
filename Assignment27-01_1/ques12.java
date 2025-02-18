import java.util.*;
public class ques12 {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double[] result = new double[3];
        double radians = Math.toRadians(angle);
        result[0] = Math.sin(radians);  
        result[1] = Math.cos(radians);  
        result[2] = Math.tan(radians);  
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();
        double[] trigonometricResults = calculateTrigonometricFunctions(angle);
        System.out.println("Sine of " + angle + " degrees: " + trigonometricResults[0]);
        System.out.println("Cosine of " + angle + " degrees: " + trigonometricResults[1]);
        System.out.println("Tangent of " + angle + " degrees: " + trigonometricResults[2]);
    }
}

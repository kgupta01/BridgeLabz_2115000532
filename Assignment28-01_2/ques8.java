import java.util.*;
public class ques8 {
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature in Fahrenheit:");
        double fahrenheit = scanner.nextDouble();
        System.out.println(fahrenheit + " Fahrenheit is " + fahrenheitToCelsius(fahrenheit) + " Celsius.");        
        System.out.println("Enter temperature in Celsius:");
        double celsius = scanner.nextDouble();
        System.out.println(celsius + " Celsius is " + celsiusToFahrenheit(celsius) + " Fahrenheit.");
    }
}

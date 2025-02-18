import java.util.*;
public class Temperature{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the temperature in Celsius");
int t=sc.nextInt();
int ans=(t*(9/5))+32;
System.out.println("Temperature in Farenheit: "+ans);
}
}

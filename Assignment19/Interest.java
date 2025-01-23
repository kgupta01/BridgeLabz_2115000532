import java.util.*;
public class Interest{
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the principle, rate and time");
int p=sc.nextInt();
int r=sc.nextInt();
int t=sc.nextInt();
System.out.println("Simple Interest: "+(p*r*t*0.01));
}
}

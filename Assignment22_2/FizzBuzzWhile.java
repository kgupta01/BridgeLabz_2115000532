package D_23_01_25.Level2;
import java.util.Scanner;
public class FizzBuzzWhile {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int number = sc.nextInt();
        if(number>0){
            int i=0;
            while(i<=number){
                if(i%3==0 && i%5==0){
                    System.out.println(i+" = FizzBuzz");
                }
                else if(i%5==0){
                    System.out.println(i+" = Buzz");
                }
                else if(i%3==0){
                    System.out.println(i+" = Fizz");
                }
                else{
                    System.out.println(i);
                }
                i++;
            }
        }
    }
}
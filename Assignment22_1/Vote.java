package D_23_01_25.Level1;
import java.util.Scanner;
public class Vote {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if(age>=18){
            System.out.println("The person's age is "+age+" and can vote");
        }
        else{
            System.out.println("The person's age is "+age+" and cannot vote");
        }
    }
}
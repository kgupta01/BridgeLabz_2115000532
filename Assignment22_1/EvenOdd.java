package D_23_01_25.Level1;
import java.util.Scanner;
public class EvenOdd {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number>0){
            for(int i=1; i<=number; i++){
                if(i%2==0){
                    System.out.println(i+" is even");
                }
                else{
                    System.out.println(i+" is odd");
                }
            }
        }
        else{
            System.out.println(number+" is not positive");
        }
    }
}
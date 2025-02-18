import java.util.*;
public class que4{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
if(n>=1){
int sum = n*(n+1)/2;
System.out.println(sum);
}
else{
System.out.println("not a natural number");
}
}
}

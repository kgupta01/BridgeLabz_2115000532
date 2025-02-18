import java.util.*;
public class que3{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
int a = sc.nextInt();
int b = sc.nextInt();
int c = sc.nextInt();
if(a>b && a>c){
System.out.println("1 is greatest among them");
}
else if(b>a && c>a){
System.out.println("2 is greatest among them");
}
else{
System.out.println("3 is the greatest amon them");
}

}
}

import java.util.*;
public class que7{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
int date = sc.nextInt();
int month=sc.nextInt();
if((month==3 && date>=20)||(month==4 && date>=1 && date<=30)||(month==5 && date>=1 
&& date<=31)||(month==6 && date<=20)){
System.out.println("We are in Spring season");
}
else{
System.out.println("We are not in spring season");
}
}
}

import java.util.Scanner;

public class Baekjoon1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     int number1=sc.nextInt();
     int number2=sc.nextInt();
        if(number1>number2){
            System.out.println(">");
        }
        if(number1<number2){
            System.out.println("<");
        }
        if(number1==number2){
            System.out.println("==");
        }
    }
}

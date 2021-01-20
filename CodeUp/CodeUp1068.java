import java.util.Scanner;

public class CodeUp1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if(num >= 90){
            System.out.println("A");
        }if(num >= 70 && num <90){
            System.out.println("B");
        }if(num >= 40 && num <70){
            System.out.println("C");
        }if(num >= 0 && num <40){
            System.out.println("D");
        }
    }
}

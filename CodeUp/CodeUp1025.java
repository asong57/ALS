import java.util.Scanner;

public class CodeUp1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("["+ number/10000+"0000"+"]");
        System.out.println("["+ number/1000%10+"000"+"]");
        System.out.println("["+ number/100%10+"00"+"]");
        System.out.println("["+ number/10%10+"0"+"]");
        System.out.println("["+ number%10+"]");
    }
}
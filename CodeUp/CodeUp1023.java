import java.util.Scanner;

public class CodeUp1023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number=sc.nextLine();
        String[] numbers=number.split("\\.");
        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
    }
}
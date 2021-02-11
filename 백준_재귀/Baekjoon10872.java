import java.util.Scanner;

public class Baekjoon10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(factorial(num));
    }
    public static int factorial(int number){
        if(number<=1) return 1;
        return number * factorial(number -1);
    }
}
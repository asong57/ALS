import java.util.Scanner;

public class CodeUp1066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        judgeEven(num1);
        judgeEven(num2);
        judgeEven(num3);
    }
    public static void judgeEven(int num){
        if(num % 2 ==0){
            System.out.println("even");
        }else {
            System.out.println("odd");
        }
    }
}

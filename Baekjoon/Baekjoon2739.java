import java.util.Scanner;

public class Baekjoon2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number= sc.nextInt();
        for(int i=1; i<10;i++){
            System.out.println(number+" * "+i+" = "+number*i);
        }
    }
}

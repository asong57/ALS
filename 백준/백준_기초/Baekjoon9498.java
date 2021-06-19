import java.util.Scanner;

public class Baekjoon9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score= sc.nextInt();
        if(score>=90 && score<=100){
            System.out.print("A");
        }
        if(score>=80 &&  score<=89){
            System.out.print("B");
        }
        if(score>=70 &&  score<=79){
            System.out.print("C");
        }
        if(score>=60 && score<=69){
            System.out.print("D");
        }
        if(score<=59){
            System.out.print("F");
        }
    }
}

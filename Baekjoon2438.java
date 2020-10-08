import java.util.Scanner;

public class Baekjoon2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number= sc.nextInt();
        String stars="";
        for(int i=0; i<number;i++){
            stars+="*";
            System.out.println(stars);
        }
    }
}

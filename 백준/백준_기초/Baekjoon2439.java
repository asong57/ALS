import java.util.Scanner;

public class Baekjoon2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number= sc.nextInt();
        String stars="";
        for(int i=0;i<number;i++){
            stars+=" ";
        }
        for(int i=0;i<number;i++){
           stars= stars.substring(1, stars.length());
           stars+="*";
            System.out.println(stars);
        }
    }
}

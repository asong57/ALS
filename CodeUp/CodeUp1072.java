import java.util.Scanner;

public class CodeUp1072 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int[] number = new int[n];
        for(int i=0; i<n; i++){
            number[i] = sc.nextInt();
            System.out.println(number[i]);
        }
    }
}

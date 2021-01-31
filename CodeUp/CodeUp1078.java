import java.util.Scanner;

public class CodeUp1078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum=0;
        for(int i=0;i<=num;i++){
           if(i %2 == 0){
               sum+=i;
           }
        }
        System.out.println(sum);
    }
}
import java.util.Scanner;

public class CodeUp1034 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String octalNumber = sc.next();
        int octalNum=Integer.parseInt(octalNumber,8);
        System.out.println(octalNum);
    }
}

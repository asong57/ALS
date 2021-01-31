import java.util.Scanner;

public class CodeUp1076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        char alphabet=word.charAt(0);
        for(char i='a';i<=alphabet;i++){
            System.out.print(i+" ");
        }
    }
}

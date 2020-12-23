import java.util.Scanner;

public class CodeUp1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        for(int i=0; i<word.length();i++){
            System.out.println("'"+word.charAt(i)+"'");
        }
    }
}

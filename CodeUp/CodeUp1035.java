import java.util.Scanner;

public class CodeUp1035 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String hexNumber = sc.next();
        int hexNum = Integer.parseInt(hexNumber,16);
        String octNum = Integer.toOctalString(hexNum);
        System.out.println(octNum);
    }
}

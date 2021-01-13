import java.util.Scanner;

public class CodeUp1027 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String dateYMD=sc.next();
        String[] dateDMY= dateYMD.split("[.]");
        System.out.println(dateDMY[2]+"-"+dateDMY[1]+"-"+dateDMY[0]);
    }
}

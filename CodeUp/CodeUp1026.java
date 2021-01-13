import java.util.Scanner;

public class CodeUp1026 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String time= sc.next();
        String[] timeZone=time.split(":");
        if(timeZone[1].equals("00")){
            System.out.println("0");
        }else{
            System.out.println(timeZone[1]);
        }
    }
}

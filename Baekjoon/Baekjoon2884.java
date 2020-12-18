import java.util.Scanner;

public class Baekjoon2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        int minute;
        int hour;
        if(M>=45){
            minute=M-45;
            System.out.println(H+" "+minute);

        }
        if(M<45 && H!=0){
            minute=M+60;
            minute=minute-45;
            hour=H-1;
            System.out.println(hour+" "+minute);
        }
        if(M<45 && H==0){
            minute=M+60;
            minute=minute-45;
            System.out.println(23+" "+minute);
        }
    }
}

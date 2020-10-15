import java.util.Scanner;

public class Baekjoon3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers=new int [10];
        int[] namuji=new int[43];
        int count=0;
        for(int i=0;i<10;i++){
            numbers[i]=sc.nextInt();
        }
        for(int i=0;i<10;i++){
            namuji[numbers[i]%42]++;
        }
        for(int i=0;i<43;i++){
            if(namuji[i]!=0){
                count++;
            }
        }
     System.out.println(count);
    }
}

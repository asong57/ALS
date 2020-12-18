import java.util.Scanner;

public class Baekjoon2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers=new int[9];
        int max;
        int maxIndex=0;
        for(int i=0; i<9;i++){
            numbers[i]=sc.nextInt();
        }
        max=numbers[0];
        for(int i=1; i<9;i++){
            if(numbers[i]>max){
                maxIndex=i;
                max=numbers[i];
            }
        }
        System.out.println(max);
        System.out.println(maxIndex+1);
    }
}

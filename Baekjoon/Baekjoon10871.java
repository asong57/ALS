import java.util.Scanner;

public class Baekjoon10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number=sc.nextInt();
        int limitNumber=sc.nextInt();
        int[] numbers=new int[number];
        for(int i=0;i<number;i++){
            numbers[i]=sc.nextInt();
        }
        for(int i=0;i<number;i++){
            if(numbers[i]<limitNumber){
                System.out.println(numbers[i]);
            }
        }
    }
}

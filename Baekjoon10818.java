import java.util.Scanner;

public class Baekjoon10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number= sc.nextInt();
        int[] numbers=new int[number];
        for(int i=0;i<number;i++){
            numbers[i]=sc.nextInt();
        }
        int min=numbers[0];
        int max=numbers[0];
        for(int i=1;i<number;i++){
            if(numbers[i]>max){
                max=numbers[i];
            }
        }
        for(int i=1;i<number;i++){
            if(numbers[i]<min){
                min=numbers[i];
            }
        }
        System.out.println(min+" "+max);

    }
}

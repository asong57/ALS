import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        int count = 1;
        int sum = 2;
        if(number == 1){
            System.out.println(1);
        }else{
            while(sum<=number){
                sum += 6*count;
                count++;
            }
            System.out.println(count);
        }
    }
}

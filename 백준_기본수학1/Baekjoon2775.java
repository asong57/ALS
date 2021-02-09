import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int k,n;
        for(int i=0;i<number;i++){
            k=Integer.parseInt(br.readLine());
            n=Integer.parseInt(br.readLine());
            System.out.println(peopleCount(k,n));
        }
    }
    public static int peopleCount(int k, int n){
        if(k==0){
            return n;
        }
        if(n==0){
            return 0;
        }
        return peopleCount(k,n-1)+peopleCount(k-1,n);
    }
}

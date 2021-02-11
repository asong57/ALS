import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(pibonachi(n));
    }
    public static int pibonachi(int n){
        if(n==1) return 1;
        if(n==0) return 0;
        return pibonachi(n-1)+pibonachi(n-2);
    }
}

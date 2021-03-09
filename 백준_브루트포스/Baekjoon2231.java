import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String jari = String.valueOf(i);
            int sum = i;
            for (int j = 0; j < jari.length(); j++) {
                sum += jari.charAt(j)-'0';
            }
            if(sum==n){
                System.out.print(i);
                return;
            }
        }
        System.out.print(0);
    }
}

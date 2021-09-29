import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2581_PrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        long sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = m; i <= n; i++) {
            boolean isPrimeNumber = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
            //소수에서 1을 제외시켜야 하는 점 잊지 말자!
            if (isPrimeNumber && i != 1) {
                sum += i;
                min = Math.min(min, i);
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);
    }
}

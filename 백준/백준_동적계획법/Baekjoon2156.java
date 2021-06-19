import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] grape = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            grape[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = grape[1];
        if (n > 1) {
            dp[2] = grape[1] + grape[2];
        }
        grape[0] = 0;
        dp[0] = 0;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(Math.max(dp[i - 2] + grape[i], dp[i - 3] + grape[i - 1] + grape[i]), dp[i - 1]);
        }

        System.out.print(dp[n]);
    }
}

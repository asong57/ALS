import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1010_MakeBridge {
    public static int m;
    public static int count;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[][] dp = new int[n + 1][m + 1];
            for (int j = 2; j <= n; j++) {
                dp[j][1] = 0;
            }
            for (int k = 1; k <= m; k++) {
                dp[1][k] = k;
            }

            for (int x = 2; x <= n; x++) {
                for (int y = 2; y <= m; y++) {
                    dp[x][y] = dp[x][y - 1] + dp[x - 1][y - 1];
                }
            }
            System.out.println(dp[n][m]);
            //makeCombination(n, temp, 0, 0);
        }
    }

    // 조합 풀이
    public static void makeCombination(int r, int[] temp, int current, int start) {
        if (current == r) {
            count++;
        } else {
            for (int i = start; i < m; i++) {
                temp[current] = i;
                makeCombination(r, temp, current + 1, i + 1);
            }
        }
    }
}

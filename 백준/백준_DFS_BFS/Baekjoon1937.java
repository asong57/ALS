import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1937 {
    //dfs, dp
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        int count = 0;
        int k;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = 0;
            while (st.hasMoreTokens()) {
                arr[i][k] = Integer.parseInt(st.nextToken());
                k++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count = Math.max(dfs(i, j), count);
            }
        }
        System.out.println(count);
    }

    public static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        //판다가 최소 1년은 살 수 있으므로
        dp[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
                if (arr[xx][yy] > arr[x][y]) {
                    dp[x][y] = Math.max(dfs(xx, yy) + 1, dp[x][y]);
                    dfs(xx, yy);
                }
            }
        }
        return dp[x][y];
    }
}

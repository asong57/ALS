import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] cost = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        cost[0][0] = arr[0][0];
        cost[0][1] = arr[0][1];
        cost[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            cost[i][0] = Math.min(cost[i - 1][1], cost[i - 1][2]) + arr[i][0];
            cost[i][1] = Math.min(cost[i - 1][0], cost[i - 1][2]) + arr[i][1];
            cost[i][2] = Math.min(cost[i - 1][0], cost[i - 1][1]) + arr[i][2];
        }

        System.out.println(Math.min(Math.min(cost[n - 1][0], cost[n - 1][1]), cost[n - 1][2]));
    }
}

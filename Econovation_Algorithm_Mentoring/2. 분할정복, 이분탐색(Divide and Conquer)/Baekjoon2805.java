import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] trees = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st2.nextToken());
            max = Math.max(trees[i], max);
        }

        int start = 1;
        int end = max;
        int mid = 0;
        int result = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (trees[i] > mid) {
                    sum += (trees[i] - mid);
                }
            }

            if (sum < m) {
                end = mid - 1;
            } else if (sum >= m) {
                start = mid + 1;
                result = Math.max(result, mid);
            }
        }
        System.out.println(result);
    }
}

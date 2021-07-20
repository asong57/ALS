import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] lansun = new long[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            lansun[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lansun[i]);
        }

        long maxLength = 0;
        long start = 1;
        long end = max;
        long mid = (end + 1) / 2;

        while (end - start >= 0) {
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += lansun[i] / mid;
            }
            if (sum < n) {
                end = mid - 1;
            }
            if (sum >= n) {
                maxLength = Math.max(maxLength, mid);
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        System.out.println(maxLength);
    }
}

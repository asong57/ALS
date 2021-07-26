import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = 0;

        int min = Integer.MAX_VALUE;
        while (left < n) {
            if (arr[right] - arr[left] < m) {
                right++;
                if (right == n) {
                    left++;
                    right = left;
                }
                continue;
            } else if (arr[right] - arr[left] >= m) {
                min = Math.min(arr[right] - arr[left], min);
                left++;
                right = left;
                if (right == n) {
                    left++;
                    right = left;
                }
            }
        }
        System.out.println(min);
    }
}

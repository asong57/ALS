import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2470_TwoLiquid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        long liquid1 = 0;
        long liquid2 = 0;
        long sum = Integer.MAX_VALUE;

        while (left < right) {
            long temp = Math.abs(arr[left] + arr[right]);

            if (temp < sum) {
                sum = temp;
                liquid1 = arr[left];
                liquid2 = arr[right];
            }

            if (arr[left] + arr[right] > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(liquid1 + " " + liquid2);
    }
}

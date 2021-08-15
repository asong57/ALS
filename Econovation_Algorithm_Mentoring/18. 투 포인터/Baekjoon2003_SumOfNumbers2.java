import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2003_SumOfNumbers2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int i = 0;
        while (st2.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st2.nextToken());
            i++;
        }

        int sum = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        while (true) {
            if (sum > m) {
                sum -= arr[left++];
            } else if (right == n) {
                break;
            } else {
                sum += arr[right++];
            }

            if (sum == m) {
                count++;
            }
        }
        System.out.println(count);
    }
}

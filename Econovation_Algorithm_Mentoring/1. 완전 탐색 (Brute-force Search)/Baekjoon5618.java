import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon5618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
        }
        for (int i = 1; i <= min; i++) {
            boolean isAnswer = true;
            for (int j = 0; j < n; j++) {
                if (arr[j] % i != 0) {
                    isAnswer = false;
                    break;
                }
            }
            if (isAnswer) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

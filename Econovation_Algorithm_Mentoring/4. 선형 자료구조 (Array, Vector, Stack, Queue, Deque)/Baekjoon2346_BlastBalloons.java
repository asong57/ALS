import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon2346_BlastBalloons {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int index = 0;
        int num = arr[0];
        arr[0] = 0;
        sb.append("1 ");
        for (int i = 0; i < n - 1; i++) {
            if (num >= 0) {
                for (int j = 0; j < num; ) {
                    index++;
                    index %= n;
                    if (arr[index] != 0) {
                        j++;
                    }
                }
            } else {
                for (int j = 0; j < num * -1; ) {
                    index--;
                    while (index < 0) {
                        index += n;
                    }
                    if (arr[index] != 0) {
                        j++;
                    }
                }
            }
            num = arr[index];
            arr[index] = 0;
            sb.append(index + 1 + " ");
        }
        System.out.println(sb.toString());
    }
}

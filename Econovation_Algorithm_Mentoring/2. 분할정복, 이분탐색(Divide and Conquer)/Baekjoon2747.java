import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] pibonachi = new int[n + 1];
        pibonachi[0] = 0;
        pibonachi[1] = 1;
        for (int i = 2; i <= n; i++) {
            pibonachi[i] = pibonachi[i - 1] + pibonachi[i - 2];
        }
        System.out.println(pibonachi[n]);
    }
}

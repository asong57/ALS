import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2443 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int j = 2 * n - 1; j > 0; j -= 2) {
            for (int k = 0; k < index; k++) {
                sb.append(" ");
            }
            index++;
            for (int i = 0; i < j; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

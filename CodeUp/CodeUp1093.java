import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers);
        int[] count = new int[24];
        int[] call = new int[n];
        for(int j=0;j<n;j++){
            call[j] = Integer.parseInt(st.nextToken());
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= 23; i++) {
                if (call[j] == i) {
                    count[i]++;
                }
            }
        }
        for (int i = 1; i <= 23; i++) {
            System.out.print(count[i] + " ");
        }
    }
}

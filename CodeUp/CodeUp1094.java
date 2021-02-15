import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers);
        int[] call = new int[n];
        for(int j=0;j<n;j++){
            call[j] = Integer.parseInt(st.nextToken());
        }
        for (int i = n-1; i >= 0; i--) {
            System.out.print(call[i] + " ");
        }
    }
}

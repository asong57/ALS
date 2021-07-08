import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hm = new HashMap<>();
            for (int k = 0; k < m; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String category = st.nextToken();
                hm.put(category, hm.getOrDefault(category, 0) + 1);
            }
            int result = 1;
            for (int count : hm.values()) {
                result *= (count + 1);
            }
            System.out.println(result - 1);
        }
    }
}

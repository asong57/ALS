import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cnt = new int[20000001];

        for(int i = 0; i < n; i++) {
            cnt[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < m; i++) {
            sb.append(cnt[Integer.parseInt(st.nextToken()) + 10000000] + " ");
        }

        System.out.println(sb);
    }
}

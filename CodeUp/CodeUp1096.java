import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 0, b = 0;
        int[][] badook = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                badook[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            String numbers = br.readLine();
            StringTokenizer st = new StringTokenizer(numbers);
            int r=Integer.parseInt(st.nextToken()) - 1;
            int j=Integer.parseInt(st.nextToken()) - 1;
            if (badook[r][j] == 0) {
                badook[r][j]++;
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(badook[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

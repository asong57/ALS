import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baekjoon2407_Combination {
    public static int n;
    public static int count;

    public static BigInteger dpCombi[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        count = 0;
        int[] temp = new int[m];
        // makeCombination(m, temp, 0, 0);
        //System.out.println(combination(n,m));

        // long 보다 더 큰 값이 나오므로 BigInteger를 사용한다.
        dpCombi = new BigInteger[1001][1001];

        setDpCombination(n, m);

        System.out.println(dpCombi[n][m]);

    }

    public static void setDpCombination(int n, int m) {

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    dpCombi[i][j] = new BigInteger("1");
                else
                    dpCombi[i][j] = dpCombi[i - 1][j - 1].add(dpCombi[i - 1][j]);
            }
        }
    }

    // 또다른 재귀 방법
    public static int combination(int n, int m) {
        if (n == m || m == 0) {
            return 1;
        }
        return combination(n - 1, m - 1) + combination(n - 1, m);
    }

    // 조합 만들기
    public static void makeCombination(int r, int[] temp, int current, int start) {
        if (r == current) {
            count++;
        } else {
            for (int i = start; i < n; i++) {
                temp[current] = i;
                makeCombination(r, temp, current + 1, i + 1);
            }
        }

    }
}

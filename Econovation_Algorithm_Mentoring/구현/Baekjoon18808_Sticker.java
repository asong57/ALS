import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon18808_Sticker {
    static int n, m, k;
    static int[][] note = new int[42][42];
    static int r, c;
    static int[][] paper = new int[12][12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //붙이면 다음으로 넘어가야됨 못붙이면 90도 돌리기.
            check:
            for (int rot = 0; rot < 4; rot++) {
                for (int x = 0; x <= n - r; x++) { // n = 7, r = 5인 상황 상상가능.
                    for (int y = 0; y <= m - c; y++) {
                        if (postable(x, y)) {
                            break check;
                        }
                    }
                }
                rotate(); // rot = 3 일때 rotate 실행시키면 안되지만 복잡도 그렇게 크게 증가 x
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += note[i][j];
            }
        }
        System.out.println(count);
    }

    static boolean postable(int x, int y) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (note[x + i][y + j] == 1 && paper[i][j] == 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (paper[i][j] == 1) {
                    note[x + i][y + j] = 1;
                }
            }
        }
        return true;
    }

    static void rotate() {
        int[][] temp = new int[12][12];
        for (int i = 0; i < r; i++) System.arraycopy(paper[i], 0, temp[i], 0, c);

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                paper[i][j] = temp[r - 1 - j][i];
            }
        }
        int tmp = r;
        r = c;
        c = tmp;
    }
}

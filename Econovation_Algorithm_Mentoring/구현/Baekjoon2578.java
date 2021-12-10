import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2578 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[5][5];
        boolean[][] check = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int a = 0; a < 5; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int b = 0; b < 5; b++) {
                int n = Integer.parseInt(st.nextToken());
                count = 0;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (arr[i][j] == n) {
                            check[i][j] = true;
                            checkGaro(check);
                            checkSero(check);
                            checkX(check);
                            if (count >= 3) {
                                System.out.println(a *5 +(b + 1));
                                return;
                            }
                        }
                    }
                }
            }
        }


    }

    // 가로 확인
    public static void checkGaro(boolean[][] check) {
        for (int i = 0; i < 5; i++) {
            boolean bingo = true;
            for (int j = 0; j < 5; j++) {
                if (!check[i][j]) {
                    bingo = false;
                }
            }
            if (bingo) {
                count++;
            }
        }
    }

    // 세로 확인
    public static void checkSero(boolean[][] check) {
        for (int j = 0; j < 5; j++) {
            boolean bingo = true;
            for (int i = 0; i < 5; i++) {
                if (!check[i][j]) {
                    bingo = false;
                }
            }
            if (bingo) {
                count++;
            }
        }
    }

    // 대각선 확인
    // 가로 확인
    public static void checkX(boolean[][] check) {
        int i = 0;
        int j = 0;
        boolean bingo = true;
        for (; i < 5; i++, j++) {
            if (!check[i][j]) {
                bingo = false;
                break;
            }
        }
        if (bingo) {
            count++;
        }
        i = 0;
        j = 4;
        bingo = true;
        for (; i < 5; i++, j--) {
            if (!check[i][j]) {
                bingo = false;
                break;
            }
        }
        if (bingo) {
            count++;
        }
    }
}

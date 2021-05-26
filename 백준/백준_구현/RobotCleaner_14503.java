import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotCleaner_14503 {
    static int count;
    static int[][] room;
    static boolean[][] isClean;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st2.nextToken());
        int c = Integer.parseInt(st2.nextToken());
        int d = Integer.parseInt(st2.nextToken());

        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int j = 0;
            while (st3.hasMoreTokens()) {
                room[i][j] = Integer.parseInt(st3.nextToken());
                j++;
            }
        }
        isClean = new boolean[n][m];
        count = 0;
        countCleanPlaces(r, c, d);
        System.out.println(count);
    }

    public static void countCleanPlaces(int r, int c, int d) {
        boolean sign = false;
        if (!isClean[r][c]) {
            isClean[r][c] = true;
            count++;
        }

        for (int i = 0; i < 4; i++) {
            d = getDirection(d);
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (room[nr][nc] == 0 && !isClean[nr][nc]) {
                sign = true;
                countCleanPlaces(nr, nc, d);
                break;
            }
        }
        if (sign == false) {
            int nr = r - dr[d];
            int nc = c - dc[d];
            if (room[nr][nc] != 1) {
                countCleanPlaces(nr, nc, d);
            }
        }
    }

    public static int getDirection(int d) {
        if (d == 0) {
            return 3;
        } else {
            return d - 1;
        }
    }

}

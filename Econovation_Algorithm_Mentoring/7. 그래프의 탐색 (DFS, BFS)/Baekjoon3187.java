import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon3187 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visit;
    static int r, c;
    static char[][] arr;
    static int totalSheep;
    static int totalWolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        totalSheep = 0;
        totalWolf = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(totalSheep + " " + totalWolf);
    }

    public static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        visit[a][b] = true;
        q.add(new int[]{a, b});
        int sheep = 0;
        int wolf = 0;

        while (!q.isEmpty()) {
            int[] location = q.poll();
            int x = location[0];
            int y = location[1];
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && yy >= 0 && xx < r && yy < c && !visit[xx][yy]) {
                    if (arr[xx][yy] == '#') {
                        continue;
                    }
                    visit[xx][yy] = true;
                    q.add(new int[]{xx, yy});
                    if (arr[xx][yy] == 'v') {
                        wolf++;
                    } else if (arr[xx][yy] == 'k') {
                        sheep++;
                    }
                }
            }
        }
        if (wolf >= sheep) {
            totalWolf += wolf;
        } else {
            totalSheep += sheep;
        }
    }
}

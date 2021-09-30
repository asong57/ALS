import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2636_Cheese {
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static boolean[][] visit;
    static int deleteCheeseCnt;
    static int deleteSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        int cheeseSize = 0;
        deleteSum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    cheeseSize++;
                }
            }
        }

        int time = 0;
        while (cheeseSize != deleteSum) {
            visit = new boolean[n][m];
            deleteCheeseCnt = 0;
            bfs();
            time++;
        }

        System.out.println(time);
        System.out.println(deleteCheeseCnt);
    }

    public static void bfs() {
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(0, 0));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            Location now = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];
                if (xx >= 0 && yy >= 0 && xx < n && yy < m && !visit[xx][yy]) {
                    if (arr[xx][yy] == 0) {
                        q.add(new Location(xx, yy));
                    } else {
                        arr[xx][yy] = 0;
                        deleteCheeseCnt++;
                    }
                    visit[xx][yy] = true;
                }
            }
        }
        deleteSum += deleteCheeseCnt;
    }
}

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

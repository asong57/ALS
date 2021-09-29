import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2638_Cheese {
    static ArrayList<Points> cheeseList;
    static int cheeseCnt = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] map;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cheeseList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseCnt++;
                    cheeseList.add(new Points(i, j));
                }
            }
        }

        int time = 0;
        while (cheeseCnt != 0) {
            time++;
            visited = new boolean[n][m];
            bfs();
            melting();
        }

        System.out.println(time);
    }

    // bfs로 외부와 접촉한 공기 2로 표시
    public static void bfs() {
        Queue<Points> queue = new LinkedList<>();
        queue.add(new Points(0, 0));
        visited[0][0] = true;
        map[0][0] = 2;

        while (!queue.isEmpty()) {
            int x = queue.peek().x;
            int y = queue.poll().y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || map[nx][ny] == 1) continue; // 외내부 공기 판별을 위해 치즈인 경우도 pass

                map[nx][ny] = 2; // 외부 공기라는 의미로 2로 바꿔줌
                queue.add(new Points(nx, ny)); // 공기인 경우만 큐에 넣어줌
                visited[nx][ny] = true;
            }
        }
    }

    static void melting() {
        for (int i = 0; i < cheeseList.size(); i++) {
            int x = cheeseList.get(i).x;
            int y = cheeseList.get(i).y;
            int cnt = 0;

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (map[nx][ny] == 2) {
                    cnt++;
                }
            }

            if (cnt >= 2) { // 외부 공기와 2변 이상 접촉한 경우
                map[x][y] = 0;
                cheeseCnt--;
                cheeseList.remove(i);
                i--;
            }
        }
    }

}

class Points {
    int x;
    int y;

    Points(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

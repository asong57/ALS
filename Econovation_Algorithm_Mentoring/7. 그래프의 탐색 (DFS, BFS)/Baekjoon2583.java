import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2583 {
    static int m, n, k;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int la = Integer.parseInt(st2.nextToken());
            int lb = Integer.parseInt(st2.nextToken());
            int ra = Integer.parseInt(st2.nextToken());
            int rb = Integer.parseInt(st2.nextToken());
            for (int j = la; j < ra; j++) {
                for (int h = lb; h < rb; h++) {
                    arr[j][h] = 1;
                }
            }
        }
        sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && arr[i][j] != 1) {
                    int count = bfs(i, j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        visit[a][b] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int[] location = q.poll();
            int x = location[0];
            int y = location[1];
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && yy >= 0 && xx < n && yy < m && !visit[xx][yy] && arr[xx][yy] != 1) {
                    q.add(new int[]{xx, yy});
                    visit[xx][yy] = true;
                    count++;
                }
            }
        }
        return count;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1260 {
    static int[][] map;
    static int n, m, start;
    static StringBuilder sb1;
    static boolean[] visitDfs;
    static StringBuilder sb2;
    static boolean[] visitBfs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        sb1 = new StringBuilder();
        sb2 = new StringBuilder();
        visitBfs = new boolean[n + 1];
        visitDfs = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(start);
        System.out.println(sb1.toString());

        bfs();
        System.out.println(sb2.toString());

    }

    public static void dfs(int start) {
        visitDfs[start] = true;
        sb1.append(start).append(" ");

        for (int i = 1; i <= n; i++) {
            if (map[start][i] == 1 && !visitDfs[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visitBfs[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            sb2.append(now).append(" ");
            for (int i = 1; i <= n; i++) {
                if (map[now][i] == 1 && !visitBfs[i]) {
                    q.add(i);
                    visitBfs[i] = true;
                }
            }
        }
    }
}

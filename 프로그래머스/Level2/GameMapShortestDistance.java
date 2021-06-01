import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {
    //bfs 활용하는 문제
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] visit;
    static int n;
    static int m;

    public int solution(int[][] maps) {
        int answer = 0;
        m = maps.length;
        n = maps[0].length;
        visit = new int[m][n];
        answer = bfs(maps, 0, 0);
        return answer;
    }

    public static int bfs(int[][] maps, int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j, 1));
        visit[i][j] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.x == m - 1 && node.y == n - 1) {
                return node.count;
            }

            for (int k = 0; k < 4; k++) {
                int xx = node.x + dx[k];
                int yy = node.y + dy[k];
                if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                    continue;
                }
                if (maps[xx][yy] == 1 && visit[xx][yy] == 0) {
                    visit[xx][yy] = 1;
                    q.offer(new Node(xx, yy, node.count + 1));
                }
            }
        }
        return -1;
    }

    public static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}

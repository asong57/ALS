import java.util.LinkedList;
import java.util.Queue;

public class RaceCourseConstruction {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int min;
    static int map[][];

    public static void main(String[] args) {
        int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        solution(board);
        System.out.println(min);
    }

    public static int solution(int[][] board) {
        int n = board.length;
        min = Integer.MAX_VALUE;
        map = board;
        bfs(0, 0, n);
        return min;
    }

    public static void bfs(int x, int y, int n) {
        Queue<Route> q = new LinkedList<>();
        map[x][y] = 1;
        q.add(new Route(x, y, 0, -1));

        while (!q.isEmpty()) {
            Route route = q.poll();

            if (route.x == n - 1 && route.y == n - 1) {
                min = Math.min(min, route.cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int xx = route.x + dx[i];
                int yy = route.y + dy[i];
                if (xx >= 0 && yy >= 0 && xx < n && yy < n && map[xx][yy] != 1) {
                    int new_cost = 0;
                    if (route.direction == -1 || i == route.direction) {
                        new_cost = route.cost + 100;
                    } else if (route.direction != i) {
                        new_cost = route.cost + 600;
                    }

                    if (map[xx][yy] == 0) {
                        map[xx][yy] = new_cost;
                        q.add(new Route(xx, yy, new_cost, i));
                    } else if (map[xx][yy] >= new_cost) {
                        map[xx][yy] = new_cost;
                        q.add(new Route(xx, yy, new_cost, i));
                    }

                }
            }
        }
    }
}

class Route {
    int x;
    int y;
    int cost;
    int direction;

    public Route(int x, int y, int cost, int index) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.direction = index;
    }
}

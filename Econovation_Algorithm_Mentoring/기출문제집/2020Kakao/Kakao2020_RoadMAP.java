import java.util.LinkedList;
import java.util.Queue;

public class Kakao2020_RoadMAP {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int min;
    static int[][] map;

    public static int solution(int[][] board) {
        min = Integer.MAX_VALUE;
        map = new int[board.length][board[0].length];

        bfs(board);
        return min;
    }

    public static void bfs(int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, -1, 0});
        map[0][0] = 1;

        while (!q.isEmpty()) {
            int[] location = q.poll();
            if (location[0] == board.length - 1 && location[1] == board[0].length - 1) {
                min = Math.min(min, location[3]);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int xx = location[0] + dx[i];
                int yy = location[1] + dy[i];

                if (xx >= 0 && yy >= 0 && xx < board.length && yy < board[0].length && board[xx][yy] == 0) {
                    int money = 0;
                    if ((i < 2 && location[2] < 2) || i >= 2 && location[2] >= 2 || location[2] == -1) {
                        money = 100 + location[3];
                    } else {
                        money = 600 + location[3];
                    }
                    if (map[xx][yy] == 0) {
                        map[xx][yy] = money;
                        q.offer(new int[]{xx, yy, i, money});
                        continue;
                    }
                    if (map[xx][yy] >= money) {
                        map[xx][yy] = money;
                        q.offer(new int[]{xx, yy, i, money});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon3055 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] arr;
    static boolean[][] visited;
    static int r, c;
    static int startX, startY, endX, endY;
    static Queue<Point> q;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[r][c];
        q = new LinkedList<>();
        startX = 0;
        startY = 0;
        endX = 0;
        endY = 0;


        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
                if (str.charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                } else if (str.charAt(j) == 'D') {
                    endX = i;
                    endY = j;
                }
            }
        }

        bfs();

    }

    public static void bfs() {
        q.add(new Point(-1, -1));
        q.add(new Point(startX, startY));

        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.x == -1) {
                water();
                answer++;
                if (!q.isEmpty()) {
                    q.add(point);
                }
                continue;
            }

            if (point.x == endX && point.y == endY) {
                System.out.println(answer - 1);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int xx = point.x + dx[i];
                int yy = point.y + dy[i];

                if (xx >= 0 && yy >= 0 && xx < r && yy < c && !visited[xx][yy] && (arr[xx][yy] == '.' || arr[xx][yy] == 'D')) {
                    visited[xx][yy] = true;
                    q.add(new Point(xx, yy));
                }
            }
        }
        System.out.println("KAKTUS");
    }

    public static void water() {
        char temp[][] = new char[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                temp[i][j] = arr[i][j];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == '*') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < r && ny < c && (arr[nx][ny] == '.' || arr[nx][ny] == 'S'))
                            temp[nx][ny] = '*';
                    }
                }
            }
        }

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                arr[i][j] = temp[i][j];
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

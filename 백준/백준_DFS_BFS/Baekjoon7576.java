import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;
    static int m;
    static Queue<tomato> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        q = new LinkedList<tomato>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.offer(new tomato(i, j));
                }
            }
        }
        int count = bfs();
        System.out.println(count);
    }

    public static int bfs() {
        while (!q.isEmpty()) {
            tomato t = q.poll();
            int x = t.x;
            int y = t.y;
            for (int k = 0; k < 4; k++) {
                int xx = x + dx[k];
                int yy = y + dy[k];
                if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
                    if (arr[xx][yy] == 0) {
                        arr[xx][yy] = arr[x][y] + 1;
                        q.offer(new tomato(xx, yy));
                    }
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 0){
                    return -1;
                }
                result = Math.max(result, arr[i][j]);
            }
        }
        if(result == 1){
            return 0;
        }else{
            return result -1;
        }
    }
}

class tomato {
    int x;
    int y;

    tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

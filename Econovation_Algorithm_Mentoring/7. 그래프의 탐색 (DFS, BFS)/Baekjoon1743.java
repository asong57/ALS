import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1743 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n;
    static int m;
    static int[][] arr;
    static int count;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a-1][b-1] = 1;
        }
        count = 0;
        visit = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j] && arr[i][j] == 1){
                    bfs(i,j);
                }
            }
        }

        System.out.println(count);
    }
    public static void bfs(int numX, int numY){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{numX,numY});
        visit[numX][numY] = true;
        int cnt = 1;

        while(!q.isEmpty()){
            int[] result = q.poll();
            int x = result[0];
            int y = result[1];
            for(int i=0;i<4;i++){
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx >=0 && yy >= 0 && xx < n && yy < m && arr[xx][yy] == 1 && !visit[xx][yy]){
                    q.add(new int[]{xx,yy});
                    visit[xx][yy] = true;
                    cnt++;
                }
            }
        }

        count = Math.max(cnt, count);
    }
}

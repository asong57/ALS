import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2178 {
    static int[] dx={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static boolean[][] visited;
    static int[][] arr;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(arr[N-1][M-1]);

    }
    public static void bfs(int x, int y){
        Queue<int[] > q = new LinkedList<>();
        q.offer(new int[] {x,y});
        while(!q.isEmpty()){
            int location[] = q.poll();
            visited[x][y] = true;
            for(int i=0;i<4;i++){
                int xx = location[0] + dx[i];
                int yy = location[1] +dy[i];

                if(xx >= 0 && yy >= 0 && xx <N && yy <M){
                    if(arr[xx][yy] != 0 && !visited[xx][yy]){
                        q.offer(new int[]{xx,yy});
                        visited[xx][yy] = true;
                        arr[xx][yy] = arr[location[0]][location[1]] +1;
                    }
                }
            }
        }
    }
}

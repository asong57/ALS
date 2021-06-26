import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.*;

public class Baekjoon1697 {
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visit = new boolean[100005];
        if (n == k) {
            System.out.println(0);
        } else {
            System.out.println(bfs(n, k));
        }
    }

    public static int bfs(int n, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        visit[n] = true;
        while (!q.isEmpty()) {
            int[] location = q.poll();
            visit[location[0]] = true;
            if (location[0] == k) {
                return location[1];
            }
            int next = location[0]-1;
            if(next >= 0 && next < 100005 && !visit[next]){
                q.add(new int[]{next, location[1] + 1});
            }
           next = location[0] + 1;
            if(next < 100005 && !visit[next]){
                q.add(new int[]{next, location[1] + 1});
            }
            next = location[0] * 2;
            if(next < 100005 && !visit[next]){
                q.add(new int[]{next, location[1] + 1});
            }

        }
        return 0;
    }

    public static void bfs2(int N, int K, int[] visited) {
        //깊이를 visited[]배열을 통해 얻기
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        while(!q.isEmpty()) {
            int pos = q.poll();

            if(pos == K) return;

            if(pos - 1 >= 0 && visited[pos - 1] == 0) {
                q.offer(pos - 1);
                visited[pos-1] = visited[pos] + 1;
            }

            if(pos + 1 <= 100000 && visited[pos + 1] == 0) {
                q.offer(pos + 1);
                visited[pos+1] = visited[pos] + 1;
            }

            if(pos * 2 <= 100000 && visited[pos * 2] == 0) {
                q.offer(pos * 2);
                visited[pos*2] = visited[pos] + 1;
            }
        }
    }
}

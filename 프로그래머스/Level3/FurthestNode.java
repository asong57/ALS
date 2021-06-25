import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FurthestNode {
    static int[] distance;
    static ArrayList<Integer>[] arr;
    static int max;
    static boolean[] visit;

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        max = 0;
        arr = new ArrayList[n+1];
        visit = new boolean[n+1];
        for(int i=0;i<=n;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0;i<edge.length;i++){
            arr[edge[i][0]].add(edge[i][1]);
            arr[edge[i][1]].add(edge[i][0]);
        }
        distance[0] = 0;
        distance[1] = 0;

        bfs(1);
        for(int i=0;i<=n;i++){
            if(distance[i] == max){
                answer++;
            }
        }

        return answer;
    }
    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = true;
        while(!q.isEmpty()){
            x = q.poll();

            for(int i=0;i<arr[x].size();i++){
                int next = arr[x].get(i);
                if(!visit[next]){
                    visit[next] = true;
                    distance[next] = Math.min(distance[x]+1, distance[next]);
                    max = Math.max(distance[next],max);
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        System.out.println(solution(6,vertex));
    }
}

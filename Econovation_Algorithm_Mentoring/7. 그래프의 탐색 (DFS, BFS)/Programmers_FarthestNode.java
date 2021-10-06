import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_FarthestNode {
    static ArrayList<ArrayList<Integer>> list;

    public static int solution(int n, int[][] edge) {
        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }

        int answer = bfs(n);
        return answer;
    }

    public static int bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        boolean[] visit = new boolean[n + 1];
        visit[1] = true;
        int max = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (max < now[1]) {
                max = now[1];
                count = 1;
            } else if (max == now[1]) {
                count++;
            }
            for (int i = 0; i < list.get(now[0]).size(); i++) {
                int next = list.get(now[0]).get(i);
                if (!visit[next]) {
                    q.add(new int[]{next, now[1] + 1});
                    visit[next] = true;
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(6, vertex));
    }
}

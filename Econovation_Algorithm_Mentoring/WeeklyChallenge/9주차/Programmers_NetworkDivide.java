import java.util.*;

public class Programmers_NetworkDivide {
    static int[][] list;
    static boolean[] visit;
    static int count;

    public static int solution(int n, int[][] wires) {
        list = new int[n + 1][n + 1];
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            list[wires[i][0]][wires[i][1]] = 1;
            list[wires[i][1]][wires[i][0]] = 1;
        }
        for (int i = 0; i < wires.length; i++) {
            list[wires[i][0]][wires[i][1]] = 0;
            list[wires[i][1]][wires[i][0]] = 0;
            visit = new boolean[n + 1];
            ArrayList<Integer> cnt = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (!visit[j]) {
                    count = 0;
                    bfs(j);
                    cnt.add(count);
                }
            }
            diff = Math.min(diff, Math.abs(cnt.get(0) - cnt.get(1)));
            list[wires[i][0]][wires[i][1]] = 1;
            list[wires[i][1]][wires[i][0]] = 1;
        }
        int answer = diff;
        return answer;
    }

    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            count++;
            for (int i = 0; i < list[0].length; i++) {
                if (list[now][i] == 1) {
                    int next = i;
                    if (!visit[next]) {
                        q.add(next);
                        visit[next] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(solution(9, wires));
    }
}

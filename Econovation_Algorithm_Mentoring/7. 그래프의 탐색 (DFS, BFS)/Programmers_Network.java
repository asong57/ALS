import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_Network {
    boolean[] visit;
    ArrayList<ArrayList<Integer>> list;
    static int count;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (computers[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }
        count = 0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                bfs(i);
            }
        }
        answer = count;

        return answer;
    }

    public void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 0; i < list.get(x).size(); i++) {
                if (!visit[list.get(x).get(i)]) {
                    q.add(list.get(x).get(i));
                    visit[list.get(x).get(i)] = true;
                }
            }

        }
        count++;
    }
}

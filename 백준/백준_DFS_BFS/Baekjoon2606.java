import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon2606 {
    static ArrayList<ArrayList<Integer>> graph;
    static int count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        count = 0;
        for (int i = 0; i < edgeNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());

            graph.get(e1).add(e2);
            graph.get(e2).add(e1);
        }

        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int v) {

        visited[v] = true;
        int y;
        for (int i = 0; i < graph.get(v).size(); i++) {
            y = graph.get(v).get(i);

            if (!visited[y]) {
                visited[y] = true;
                count++;
                dfs(y);
            }
        }
    }
}

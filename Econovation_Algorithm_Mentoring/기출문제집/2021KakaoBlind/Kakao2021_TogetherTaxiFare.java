import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Kakao2021_TogetherTaxiFare {
    ArrayList<ArrayList<Edge>> graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < fares.length; i++) {
            graph.get(fares[i][0]).add(new Edge(fares[i][1], fares[i][2]));
            graph.get(fares[i][1]).add(new Edge(fares[i][0], fares[i][2]));
        }
        int max = 199 * 100000 + 1;
        int[] costA = new int[n + 1];
        Arrays.fill(costA, max);
        costA = dijkstra(a, costA);
        int[] costB = new int[n + 1];
        Arrays.fill(costB, max);
        costB = dijkstra(b, costB);
        int[] costS = new int[n + 1];
        Arrays.fill(costS, max);
        costS = dijkstra(s, costS);

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, costA[i] + costB[i] + costS[i]);
        }

        return answer;
    }

    public int[] dijkstra(int start, int[] costSet) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        costSet[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            int nIndex = now.index;
            int nCost = now.cost;
            if (nCost > costSet[nIndex]) {
                continue;
            }

            for (Edge edge : graph.get(nIndex)) {
                int eIndex = edge.index;
                int eCost = edge.cost;
                if (costSet[eIndex] > eCost + costSet[nIndex]) {
                    costSet[eIndex] = eCost + costSet[nIndex];
                    pq.add(new Edge(eIndex, costSet[eIndex]));
                }
            }
        }
        return costSet;
    }
}

class Edge implements Comparable<Edge> {
    public int index;
    public int cost;

    Edge(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
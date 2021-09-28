import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon2822_ScoreCalculation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= 8; i++) {
            int n = Integer.parseInt(br.readLine());
            hm.put(n, i);
            pq.add(n);
        }
        pq.poll();
        pq.poll();
        pq.poll();
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> order = new PriorityQueue<>();
        for (int i = 0; i < 5; i++) {
            int n = pq.poll();
            sum += n;
            order.add(hm.get(n));
        }
        for (int i = 0; i < 5; i++) {
            sb.append(order.poll()).append(" ");
        }
        System.out.println(sum);
        System.out.println(sb.toString());
    }
}

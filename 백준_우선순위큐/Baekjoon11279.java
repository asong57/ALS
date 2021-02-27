import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon11279 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int num;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            if (num > 0) {
                queue.offer(num);
            } else {
                if (queue.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}

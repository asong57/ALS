import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            String word = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (word.equals("I")) {
                pq.add(value);
                maxPq.add(value);
            } else {
                if (!pq.isEmpty()) {
                    if (value < 0) {
                        int min = pq.poll();
                        maxPq.remove(min);
                    } else {
                        int max = maxPq.poll();
                        pq.remove(max);
                    }

                }
            }
        }

        if (!pq.isEmpty()) {
            answer[0] = maxPq.peek();
            answer[1] = pq.peek();
        }
        return answer;
    }
}

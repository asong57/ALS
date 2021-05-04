import java.util.PriorityQueue;

public class Spicer {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue();
        for (int i = 0; i < scoville.length; i++) {
            heap.add(scoville[i]);
        }

        while (heap.peek() > K) {
            if(heap.size() < 2) return -1;
            int a = heap.poll();
            int b = heap.poll();

            int c = a + 2 * b;
            heap.add(c);
            answer++;
        }
        return answer;
    }
}

import java.util.*;

public class Kakao2019_MuziMukBangLive {
    public static int solution(int[] food_times, long k) {
        long sum = 0;
        for (int i = 0; i < food_times.length; i++) {
            sum += food_times[i];
        }
        if (sum <= k) {
            return -1;
        }

        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.add(new Food(food_times[i], i + 1));
        }
        sum = 0;
        long prev_time = 0;
        long len = food_times.length;

        while (sum + (pq.peek().time - prev_time) * len <= k) {
            int now = pq.poll().time;
            sum += (now - prev_time) * len;
            len -= 1;
            prev_time = now;
        }

        ArrayList<Food> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }

        Collections.sort(list, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.idx, o2.idx);
            }
        });

        return list.get((int) ((k - sum) % len)).idx;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        System.out.println(solution(arr, 5));
    }
}

class Food implements Comparable<Food> {
    int time;
    int idx;

    Food(int t, int i) {
        this.time = t;
        this.idx = i;
    }

    @Override
    public int compareTo(Food o) {
        return this.time - o.time;
    }
}

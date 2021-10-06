import java.util.HashMap;
import java.util.Map;

public class Programmers_CheckInOut {
    public static int[] solution(int[] enter, int[] leave) {
        int people = enter.length;
        int[] answer = new int[people];
        Map<Integer, Integer> room = new HashMap<>();
        int i = 0;
        int j = 0;
        while (i != people && j != people) {
            room.put(enter[i], enter[i]);
            if (room.size() > 1) {
                for (int key : room.keySet()) {
                    answer[key - 1]++;
                }
                answer[enter[i] - 1] += room.size() - 2;
            }

            while (true) {
                if (j < people && room.containsKey(leave[j])) {
                    room.remove(leave[j]);
                    j++;

                } else {
                    break;
                }
            }
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] enter = {1, 4, 2, 3};
        int[] leave = {2, 1, 3, 4};
        solution(enter, leave);
    }
}

import java.util.ArrayList;
import java.util.HashMap;

public class Compaction2 {
    public int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 1;
        HashMap<String, Integer> hm = new HashMap<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            hm.put(i + "", idx++);
        }
        int size = msg.length();
        for (int i = 0; i < size; i++) {
            int len = 1;
            while (i + len <= size && hm.containsKey(msg.substring(i, i + len))) {
                len++;
            }
            if (i + len > size) {
                list.add(hm.get(msg.substring(i)));
                break;
            }
            list.add(hm.get(msg.substring(i, i + len - 1)));
            hm.put(msg.substring(i, i + len), idx++);
            if (len > 1) {
                i += len - 2;
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

}

import java.util.ArrayList;
import java.util.HashMap;

public class Compaction {
    //마지막 인덱스 처리 오류 있음..
    static ArrayList<Integer> list;
    static HashMap<String, Integer> hm;
    static String str;
    static String next;
    static int index2;
    static int index;

    public static int[] solution(String msg) {
        index = 1;
        char c = 'A';
        list = new ArrayList<>();
        hm = new HashMap<>();
        while (index < 27) {
            hm.put(String.valueOf(c), index);
            index++;
            c++;
        }
        str = "";
        next = "";

        index2 = 0;

        while (index2 < msg.length() - 1) {
            recur(index2, msg);
        }


        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void recur(int idx, String msg) {
        str = "";
        next = "" + msg.charAt(idx);
        for (int i = idx; i < msg.length() - 1; i++) {
            str = next;
            next = next + msg.charAt(i + 1);
            if (hm.containsKey(next)) {
                if (i == msg.length() - 2) {
                    list.add(hm.get(next));
                    index2 = i + 1;
                }
                continue;
            } else {
                if (i == msg.length() - 2) {
                    list.add(hm.get(str));
                    index2 = i + 1;
                    return;
                }
                index2 = i + 1;

                list.add(hm.get(str));
                hm.put(next, index++);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] answer = solution("TOBEORNOTTOBEORTOBEORNOT");
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}

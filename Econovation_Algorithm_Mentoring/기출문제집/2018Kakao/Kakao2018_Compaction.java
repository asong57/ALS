import java.util.ArrayList;
import java.util.HashMap;

public class Kakao2018_Compaction {
    public static int[] solution(String msg) {
        ArrayList<Integer> list = new ArrayList();
        HashMap<String, Integer> hm = new HashMap<>();
        String alphabet = "";
        char c = 'A';
        for (int i = 1; i < 27; i++) {
            alphabet = alphabet + c;
            hm.put(alphabet, i);
            alphabet = "";
            c++;
        }

        String temp = "";
        String before = "";
        int index = 0;
        temp += msg.charAt(0);
        while (index < msg.length()) {

            while (hm.containsKey(temp)) {
                index++;

                if (index >= msg.length()) {
                    break;
                }
                temp += msg.charAt(index);
            }
            if (index == msg.length()) {
                before = temp;
            } else {
                before = temp.substring(0, temp.length() - 1);
            }

            list.add(hm.get(before));
            hm.put(temp, hm.size() + 1);
            if (index >= msg.length()) {
                break;
            }
            temp = msg.charAt(index) + "";

        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = solution("TOBEORNOTTOBEORTOBEORNOT");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}

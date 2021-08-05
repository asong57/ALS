import java.util.HashMap;
import java.util.HashSet;

public class Kakao2019TWO {
    //튜플
    public static int[] solution(String s) {
        int count = 1;
        HashMap<Integer, String> hm = new HashMap<>();
        String str = "";
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == ',') {
                str += ",";
                count++;
                continue;
            }
            if (s.charAt(i) == '{') {
                count = 1;
                str = "";
                continue;
            }
            if (s.charAt(i) == '}') {
                hm.put(count, str);
                continue;
            }
            str += s.charAt(i);
        }
        int[] answer = new int[hm.size()];
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 1; i <= hm.size(); i++) {
            String[] numbers = hm.get(i).split(",");
            for (int j = 0; j < numbers.length; j++) {
                int number = Integer.parseInt(numbers[j]);
                if (!hs.contains(number)) {
                    hs.add(number);
                    answer[i - 1] = number;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        int[] answer = solution(s);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}

import java.util.HashMap;
import java.util.HashSet;

public class Kakao2020_GemShopping {
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            if (!hs.contains(gems[i])) {
                hs.add(gems[i]);
            }
        }
        int total = hs.size();

        HashSet<String> gemSet;
        HashMap<Integer, Integer> count = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gems.length - total; i++) {
            gemSet = new HashSet<>();

            for (int j = i; j < gems.length; j++) {
                if (!gemSet.contains(gems[j])) {
                    gemSet.add(gems[j]);
                }

                if (gemSet.size() == total) {
                    if (!count.containsKey(j - i)) {
                        count.put(j - i, i);
                    }
                    break;
                }
            }
        }

        for (int n : count.keySet()) {
            min = Math.min(min, n);
        }
        System.out.println(min);
        answer[0] = count.get(min) + 1;
        answer[1] = min + answer[0];
        return answer;
    }

    public static void main(String[] args) {
        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
        System.out.println(solution(gems)[0] + " " + solution(gems)[1]);
    }
}

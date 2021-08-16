import java.util.HashMap;
import java.util.HashSet;

public class Kakao2020_GemShopping {
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];

        HashSet<String> hs = new HashSet<>();
        for (String gem : gems) {
            hs.add(gem);
        }
        int m = hs.size();

        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;

        HashMap<String, Integer> hm = new HashMap<>();

        while (true) {
            if (hm.size() == m) {
                hm.put(gems[left], hm.get(gems[left]) - 1);
                if (hm.get(gems[left]) == 0) {
                    hm.remove(gems[left]);
                }
                left++;
            } else if (right == gems.length) {
                break;
            } else {
                hm.put(gems[right], hm.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if (hm.size() == m) {
                if (right - left < min) {
                    min = right - left;
                    minLeft = left;
                    minRight = right;
                } else if (right - left == min) {
                    if (minLeft > left) {
                        minLeft = left;
                        minRight = right;
                    }
                }
            }
        }
        answer[0] = minLeft + 1;
        answer[1] = minRight;
        return answer;
    }

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(solution(gems)[0] + " " + solution(gems)[1]);
    }
}

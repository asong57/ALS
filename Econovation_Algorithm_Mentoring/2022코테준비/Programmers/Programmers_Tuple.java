import java.util.*;

public class Programmers_Tuple {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        String[] groups = s.split("\\{");
        HashMap<Integer, String[]> hm = new HashMap<>();

        for (int i = 0; i < groups.length; i++) {
            String[] strs = groups[i].split("\\}");
            String str = strs[0];
            String[] strSplit = str.split(",");
            hm.put(strSplit.length, strSplit);
        }
        int[] answer = new int[hm.size()];
        HashSet<Integer> hs = new HashSet<>();
        l:
        for (int i = 1; i <= hm.size(); i++) {
            String[] str = hm.get(i);
            for (int j = 0; j < str.length; j++) {
                int n = Integer.parseInt(str[j]);
                if (!hs.contains(n)) {
                    hs.add(n);
                    answer[i - 1] = n;
                    continue l;
                }
            }
        }

        return answer;
    }
}

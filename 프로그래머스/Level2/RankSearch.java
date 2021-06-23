import java.util.*;

public class RankSearch {
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            String[] t = info[i].split(" ");
            int score = Integer.parseInt(t[4]);
            dfs(0, "", t, score);
        }

        //map의 value List 각각 정렬하기
        for (String key : map.keySet()) {
            ArrayList<Integer> tmp = map.get(key);
            Collections.sort(tmp);
        }

        for (int i = 0; i < query.length; i++) {
            String query_str = "";
            String[] t = query[i].split(" ");

            //query String으로 만들기
            for (int j = 0; j < t.length - 1; j++) {
                if (t[j].equals("and")) {
                    continue;
                }
                query_str += t[j];
            }

            int score = Integer.parseInt(t[t.length - 1]);
            if (map.containsKey(query_str)) {
                ArrayList<Integer> tmp = map.get(query_str);
                int num = lower_bound(tmp, score);
                answer[i] = num;
            }
        }


        return answer;
    }


    //이진 검색 (해당 점수 이상인 리스트 값들의 크기 리턴)
    public static int lower_bound(ArrayList<Integer> list, int score) {
        int start = 0;
        int end = list.size();

        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return list.size() - end;
    }

    //조합 만들기
    public static void dfs(int level, String tmp, String[] str, int score) {
        if (level == 4) {
            ArrayList<Integer> list = new ArrayList<>();
            if (map.containsKey(tmp)) {
                list = map.get(tmp);
            }
            list.add(score);
            map.put(tmp, list);
            return;
        }
        dfs(level + 1, tmp + str[level], str, score);
        dfs(level + 1, tmp + "-", str, score);
    }
}

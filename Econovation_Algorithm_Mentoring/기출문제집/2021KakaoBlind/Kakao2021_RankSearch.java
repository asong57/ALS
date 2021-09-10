import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Kakao2021_RankSearch {
    static HashMap<String, ArrayList<Integer>> hm;
    static int[] arr;

    public static int[] solution(String[] info, String[] query) {
        arr = new int[]{0, 1, 2, 3};
        hm = new HashMap<>();
        hm.put("----", new ArrayList<>());
        for (int i = 0; i < info.length; i++) {
            String[] infoSet = info[i].split(" ");
            ArrayList<Integer> list = hm.get("----");
            list.add(Integer.parseInt(infoSet[4]));
            hm.put("----", list);
            String infos = infoSet[0] + infoSet[1] + infoSet[2] + infoSet[3];
            if (!hm.containsKey(infos)) {
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(Integer.parseInt(infoSet[4]));
                hm.put(infos, list1);
            } else {
                ArrayList<Integer> list1 = hm.get(infos);
                list1.add(Integer.parseInt(infoSet[4]));
                hm.put(infos, list1);
            }

            for (int j = 1; j < 4; j++) {
                int[] temp = new int[j];
                makeCombination(j, temp, 0, 0, infoSet);
            }
        }

        int[] answer = new int[query.length];
        for (String key : hm.keySet()) {
            ArrayList<Integer> tmp = hm.get(key);
            Collections.sort(tmp);
        }

        for (int i = 0; i < query.length; i++) {
            String[] querySet = query[i].split(" ");
            String str = "";
            str = querySet[0] + querySet[2] + querySet[4] + querySet[6];

            if (!hm.containsKey(str)) {
                answer[i] = 0;
                continue;
            }
            ArrayList<Integer> list = hm.get(str);
            int count = binarySearch(list, Integer.parseInt(querySet[querySet.length - 1]));

            answer[i] = count;
        }

        return answer;
    }

    static int binarySearch(ArrayList<Integer> list, int score) {
        int count = 0;
        int left = 0;
        int right = list.size();
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (list.get(mid) >= score) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        count = list.size() - right;

        return count;
    }

    private static void makeCombination(int r, int[] temp, int current, int start, String[] infoSet) {
        if (r == current) {
            String str = "";
            int index = 0;
            for (int i = 0; i < 4; i++) {
                if (temp[index] == i) {
                    str = str + infoSet[temp[index]];
                    index++;
                    if (index >= temp.length) {
                        index--;
                    }
                } else {
                    str = str + "-";
                }
            }

            if (!hm.containsKey(str)) {
                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(Integer.parseInt(infoSet[4]));
                hm.put(str, list1);
            } else {
                ArrayList<Integer> list1 = hm.get(str);
                list1.add(Integer.parseInt(infoSet[4]));
                hm.put(str, list1);
            }
        } else {
            for (int i = start; i < 4; i++) {
                temp[current] = arr[i];
                makeCombination(r, temp, current + 1, i + 1, infoSet);
            }
        }
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] result = solution(info, query);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

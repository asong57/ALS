import java.util.*;

public class Kakao2021_MenuRenewal {
    static Character[] arr;
    static HashMap<String, Integer> hm;

    public static String[] solution(String[] orders, int[] course) {

        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < orders[i].length(); j++) {
                if (!hs.contains(orders[i].charAt(j))) {
                    hs.add(orders[i].charAt(j));
                }
            }
        }

        arr = hs.toArray(new Character[0]);
        hm = new HashMap<>();

        for (int i = 0; i < course.length; i++) {
            Character[] temp = new Character[course[i]];
            makeCombination(course[i], temp, 0, 0, orders);
        }

        PriorityQueue<String> pq = new PriorityQueue<>();

        HashMap<Integer, Integer> max = new HashMap<>();
        for (String temp : hm.keySet()) {
            if (!max.containsKey(temp.length())) {
                max.put(temp.length(), hm.get(temp));
            } else {
                if (max.get(temp.length()) < hm.get(temp)) {
                    max.put(temp.length(), hm.get(temp));
                }
            }
        }

        for (String temp : hm.keySet()) {
            if (hm.get(temp) >= 2 && max.get(temp.length()) == hm.get(temp)) {
                pq.add(temp);
            }
        }

        String[] answer = new String[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }

        return answer;
    }

    public static void makeCombination(int r, Character[] temp, int current, int start, String[] orders) {
        if (r == current) {
            String tempStr = "";
            for (int i = 0; i < temp.length; i++) {
                tempStr = tempStr + temp[i];
            }
            for (int i = 0; i < orders.length; i++) {
                int count = 0;
                l:
                for (int j = 0; j < orders[i].length(); j++) {
                    for (int k = 0; k < tempStr.length(); k++) {
                        if (orders[i].charAt(j) == tempStr.charAt(k)) {
                            count++;
                            continue l;
                        }
                    }
                }
                if (count == tempStr.length()) {
                    hm.put(tempStr, hm.getOrDefault(tempStr, 0) + 1);
                }
            }


        } else {
            for (int i = start; i < arr.length; i++) {
                temp[current] = arr[i];
                makeCombination(r, temp, current + 1, i + 1, orders);
            }
        }
    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] arr = {2, 3, 4};
        String[] answer = solution(orders, arr);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}

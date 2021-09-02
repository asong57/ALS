import java.util.*;

public class Kakao2019_FailureRate {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Double[] rate = new Double[N + 2];
        double sum = stages.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Double, ArrayList<Integer>> hm2 = new HashMap<>();

        for (int i = 0; i < stages.length; i++) {
            hm.put(stages[i], hm.getOrDefault(stages[i], 0) + 1);
        }
        for (int i = 1; i < N + 1; i++) {
            if (hm.containsKey(i)) {
                rate[i] = (double) hm.get(i) / sum;
                sum -= hm.get(i);
                ArrayList<Integer> list2 = new ArrayList<>();
                if (hm2.containsKey(rate[i])) {
                    list2 = hm2.get(rate[i]);
                }
                list2.add(i);
                hm2.put(rate[i], list2);
            } else {
                rate[i] = 0.0;
                ArrayList<Integer> list2 = new ArrayList<>();
                if (hm2.containsKey(rate[i])) {
                    list2 = hm2.get(rate[i]);
                }
                list2.add(i);
                hm2.put(rate[i], list2);
            }
        }

        Arrays.sort(rate, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o1 != null && o2 != null) {
                    if (o1 > o2) {
                        return -1;
                    }
                    if (o2 > o1) {
                        return 1;
                    }
                    return 0;
                }
                return 0;
            }
        });

        int index = 0;
        double temp = -1;
        for (int i = 0; i < N; ) {
            if (temp == rate[i + 1]) {
                i++;
                continue;
            } else {
                temp = rate[i + 1];
            }
            if (hm2.containsKey(rate[i + 1])) {
                for (int j = 0; j < hm2.get(rate[i + 1]).size(); j++) {
                    answer[index] = hm2.get(rate[i + 1]).get(j);
                    index++;
                }
            }
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] answer = solution(5, stages);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(" " + answer[i]);
        }
    }
}

import java.util.*;

public class Programmers_BoxerSort {
    public int[] solution(int[] weights, String[] head2head) {
        ArrayList<Boxer> list = new ArrayList<>();
        for (int i = 0; i < head2head.length; i++) {
            int fightCnt = 0;
            int winCnt = 0;
            int heavyCnt = 0;

            for (int j = 0; j < head2head[i].length(); j++) {
                char c = head2head[i].charAt(j);
                if (c == 'N') {
                    continue;
                } else if (c == 'L') {
                    fightCnt++;
                } else {
                    fightCnt++;
                    winCnt++;
                    if (weights[i] < weights[j]) {
                        heavyCnt++;
                    }
                }
            }
            double rate = 0;
            if (fightCnt != 0) {
                rate = (double) winCnt / (double) fightCnt;
            }
            list.add(new Boxer(rate, heavyCnt, i));
        }
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Boxer o1, Boxer o2) {
                if (o1.rate == o2.rate) {
                    if (o1.count == o2.count) {
                        if (weights[o2.index] == weights[o1.index]) {
                            return o1.index - o2.index;
                        }
                        return weights[o2.index] - weights[o1.index];
                    }
                    return o2.count - o1.count;
                }
                if (o2.rate > o1.rate) {
                    return 1;
                } else if (o2.rate < o1.rate) {
                    return -1;
                }
                return 0;
            }
        });

        int[] answer = new int[weights.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).index + 1;
        }
        return answer;
    }
}

class Boxer {
    double rate;
    int count;
    int index;

    public Boxer(double r, int c, int i) {
        this.rate = r;
        this.count = c;
        this.index = i;
    }
}

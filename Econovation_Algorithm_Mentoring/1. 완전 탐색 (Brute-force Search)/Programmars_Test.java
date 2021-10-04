import java.util.ArrayList;

public class Programmars_Test {
    public int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (arr1[i % 5] == answers[i]) {
                cnt1++;
            }
            if (arr2[i % 8] == answers[i]) {
                cnt2++;
            }
            if (arr3[i % 10] == answers[i]) {
                cnt3++;
            }
        }
        int max = -1;
        ArrayList<Integer> list = new ArrayList<>();
        if (cnt1 > max) {
            max = cnt1;
            list.add(1);
        }

        if (cnt2 > max) {
            max = cnt2;
            list.remove(0);
            list.add(2);
        } else if (cnt2 == max) {
            list.add(2);
        }

        if (cnt3 > max) {
            list.clear();
            list.add(3);
        } else if (max == cnt3) {
            list.add(3);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

import java.util.ArrayList;

public class Programmars42840 {
    public int[] solution(int[] answers) {
        int[] stu1 = {1, 2, 3, 4, 5};
        int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if(stu1[i%stu1.length] == answers[i]){
                cnt1++;
            }
            if(stu2[i%stu2.length] == answers[i]){
                cnt2++;
            }
            if(stu3[i%stu3.length] == answers[i]){
                cnt3++;
            }
        }


        ArrayList<Integer> winner = new ArrayList<>();
        int max = Math.max(Math.max(cnt1, cnt2), cnt3);

        if (max == cnt1) {
            winner.add(1);
        }
        if (max == cnt2) {
            winner.add(2);
        }
        if (max == cnt3) {
            winner.add(3);
        }
        int[] answer = {};
        answer = new int[winner.size()];

        for(int i=0; i<winner.size();i++){
            answer[i] = winner.get(i);
        }

        return answer;
    }
}

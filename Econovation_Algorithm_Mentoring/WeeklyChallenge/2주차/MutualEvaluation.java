import javax.swing.*;

public class MutualEvaluation {
    public static String solution(int[][] scores) {
        String answer = "";

        int min;
        int max;
        for (int i = 0; i < scores[0].length; i++) {
            int mine = scores[i][i];
            min = Integer.MAX_VALUE;
            max = -1;
            int count = 0;
            double sum = 0;
            for (int j = 0; j < scores.length; j++) {
                min = Math.min(scores[j][i], min);
                max = Math.max(max, scores[j][i]);
                sum += scores[j][i];
                if (mine == scores[j][i]) {
                    count++;
                }
            }
            if (count == 1 && (min == mine || max == mine)) {
                sum -= mine;
                sum = (double) sum / (double) (scores.length - 1);
            } else {
                sum /= (double) scores.length;
            }

            if (sum >= 90) {
                answer += "A";
                continue;
            } else if (sum >= 80) {
                answer += "B";
                continue;
            } else if (sum >= 70) {
                answer += "C";
                continue;
            } else if (sum >= 50) {
                answer += "D";
                continue;
            } else if (sum < 50) {
                answer += "F";
                continue;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = {{70, 49, 90}, {68, 50, 38}, {73, 31, 100}};
        System.out.println(solution(arr));
    }
}

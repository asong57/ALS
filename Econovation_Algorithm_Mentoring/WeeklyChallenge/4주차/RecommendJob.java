public class RecommendJob {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";

        int[] sum = new int[5];

        for (int j = 0; j < languages.length; j++) {
            for (int i = 0; i < table.length; i++) {
                String[] scores = table[i].split(" ");
                for (int k = 1; k < scores.length; k++) {
                    if (scores[k].equals(languages[j])) {
                        sum[i] += (6 - k) * preference[j];
                    }
                }
            }
        }

        int max = 0;
        if (max < sum[1]) {
            max = sum[1];
            answer = "CONTENTS";
        }
        if (max < sum[4]) {
            max = sum[4];
            answer = "GAME";
        }
        if (max < sum[2]) {
            max = sum[2];
            answer = "HARDWARE";
        }
        if (max < sum[3]) {
            max = sum[3];
            answer = "PORTAL";
        }
        if (max < sum[0]) {
            answer = "SI";
        }

        return answer;
    }
}

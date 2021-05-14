import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        double[] stage = new double[N + 1];

        for (int i = 0; i < stages.length; i++) {
            if(stages[i] == N+1){
                continue;
            }
            stage[stages[i]]++;
        }

        ArrayList<Double> failRate = new ArrayList();
        double sum = stages.length;
        double now =0;
        for (int i = 1; i < stage.length; i++) {
            now = stage[i];
            if (sum == 0) {
                stage[i] = 0;
            }else{
                stage[i] = stage[i] / sum;
                sum = sum - now;
            }
            failRate.add(stage[i]);
        }
        Collections.sort(failRate, Collections.reverseOrder());

        for(int i=0;i<failRate.size();i++){
            for(int j=1;j<stage.length;j++){
                if(failRate.get(i) == stage[j]){
                    answer[i] = j;
                    stage[j] = -1;
                    break;
                }
            }

        }
        return answer;
    }
}

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int h=0;h<citations[citations.length-1];h++){
            int count = 0;
            for(int i=0; i<citations.length;i++){
                if(h<=citations[i]){
                    count++;
                }
            }
            if(count>=h){
                answer = Math.max(answer,h);
            }
        }

        return answer;
    }
}

import java.util.ArrayList;
import java.util.Collections;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> prior = new ArrayList<Integer>();
        ArrayList<Integer> index = new ArrayList<>();

        for(int i=0; i<priorities.length;i++){
            prior.add(priorities[i]);
            index.add(i);
        }

        int count = 0;
        while(true){
            int idx = index.get(0);
            int p = prior.get(0);
            index.remove(0);
            prior.remove(0);

            if(prior.size() == 0){
                answer += count +1 ;
                break;
            }

            if(Collections.max(prior) > p){
                prior.add(p);
                index.add(idx);
            }else{
                count += 1;
                if(location == idx ){
                    answer = count;
                    break;
                }
            }
        }

        return answer;
    }
}

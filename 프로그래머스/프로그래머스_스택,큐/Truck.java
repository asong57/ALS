import java.util.LinkedList;
import java.util.Queue;

public class Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        int current_weight = 0;
        for(int truck : truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.add(truck);
                    answer++;
                    current_weight += truck;
                    break;
                }else if(q.size() == bridge_length){
                    current_weight -= q.poll();
                }else if(current_weight + truck <= weight){
                    q.add(truck);
                    current_weight += truck;
                    answer++;
                    break;
                }else{
                    q.offer(0);
                    answer++;
                }
            }
        }
        return answer + bridge_length;
    }
}

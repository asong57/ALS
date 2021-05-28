import java.util.Arrays;

public class SavingBoat {
    //보트에 가장 무게가 많이 나가는 사람과 가장 적게 나가는 사람을 같이 보낸다는 논리

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        for (int max = people.length - 1, min = 0; max >= min; max--) {
           if(people[max] + people[min] <= limit){
               min++;
               answer++;
           }else{
               answer++;
           }
        }
        return answer;
    }
}

import java.util.HashSet;

public class LottoHighestLowestRank {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<win_nums.length;i++){
            hs.add(win_nums[i]);
        }
        int cnt = 0;
        int zeroCnt = 0;
        for(int i=0;i<lottos.length;i++){
            if(hs.contains(lottos[i])){
                cnt++;
            }else if(lottos[i] == 0){
                zeroCnt++;
            }
        }

        answer[0] = checkRank(zeroCnt+cnt);
        answer[1] = checkRank(cnt);

        if(zeroCnt == 6){
            answer[0] = 1;
        }
        return answer;
    }
    public int checkRank(int cnt){
        if(cnt == 6){
            return 1;
        }
        if(cnt == 5){
            return 2;
        }
        if(cnt == 4){
            return 3;
        }
        if(cnt == 3){
            return 4;
        }
        if(cnt == 2){
            return 5;
        }
        return 6;
    }
}

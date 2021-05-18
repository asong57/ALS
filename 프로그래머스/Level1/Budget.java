import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum=0;
        int count=0;

       for(int i=0; i< d.length;i++){
           sum += d[i];
           if(sum <= budget){
               count++;
           }
       }
        return count;
    }

}

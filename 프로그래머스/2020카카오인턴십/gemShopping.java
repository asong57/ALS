import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class gemShopping {
    public static void main(String[] args){
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(solution(gems)[0]+" "+solution(gems)[1]);
    }
    public static int[] solution(String[] gems) {
        Queue<String> q= new LinkedList<String>();
        HashSet<String> hs = new HashSet<String>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int startPoint = 0;
        int length=Integer.MAX_VALUE;
        int start = 0;

        int[] answer = {};

        for(String gem : gems){
            hs.add(gem);
        }

        for(String gem: gems){
            q.add(gem);
            hm.put(gem, hm.getOrDefault(gem,0)+1);

            while(true) {
                String temp = q.peek();
                if (hm.get(temp) > 1) {
                    q.poll();
                    hm.put(temp, hm.get(temp) - 1);
                    startPoint++;
                }else{
                    break;
                }
            }

            if(hm.size() == hs.size() && length>q.size() ){
                length = q.size();
                start = startPoint;
            }
        }


        return new int[]{start+1, start+length};
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MenuRenewal {
    //문자열별로 조합 만들기, 조합들 해시맵으로 카운트하기
    //가장 많이 카운트된 조합 우선순위큐에 넣기, 우선순위큐를 통해 오름차순 정렬 구현됨.
    
    static HashMap<String, Integer> map;
    static int m;
    public String[] solution(String[] orders, int[] course){
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int i=0;i<course.length;i++){
            map = new HashMap<>();
            m = 0;
            for(int j=0;j<orders.length;j++){
                find(0,"", course[i], 0, orders[j]);
            }
            for(String s:map.keySet()){
                if(map.get(s) == m && m>1){
                    pq.offer(s);
                }
            }
        }
        String ans[] = new String[pq.size()];
        int k=0;
        while(!pq.isEmpty()){
            ans[k++] = pq.poll();
        }
        return ans;
    }
    static void find(int cnt, String str, int targetNum, int idx, String word){
        if(cnt == targetNum){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temps="";
            for(int i=0;i<c.length;i++){
                temps += c[i];
            }
            map.put(temps, map.getOrDefault(temps, 0)+1);
            m = Math.max(m, map.get(temps));
            return;
        }
        for(int i=idx;i<word.length();i++){
            char now = word.charAt(i);
            find(cnt+1, str+now, targetNum, i+1, word);
        }
    }
}

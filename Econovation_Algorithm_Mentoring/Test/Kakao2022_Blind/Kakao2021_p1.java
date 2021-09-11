import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Kakao2021_p1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> idMap = new HashMap<>();
        HashMap<String, Integer> countHm = new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            idMap.put(id_list[i], new HashSet<String>());
        }
        for(int i=0;i<report.length;i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            String report1 = st.nextToken();
            String report2 = st.nextToken();
            HashSet<String> hs = idMap.get(report1);
            if(!hs.contains(report2)){
                hs.add(report2);
                countHm.put(report2, countHm.getOrDefault(report2, 0)+1);
            }
            idMap.put(report1,hs);
        }
        int[] answer = new int[id_list.length];
        for(int i=0;i<id_list.length;i++){
            HashSet<String> hs = idMap.get(id_list[i]);
            int count = 0;
            for(String id : hs){
                if(countHm.get(id) >= k){
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args){

    }
}

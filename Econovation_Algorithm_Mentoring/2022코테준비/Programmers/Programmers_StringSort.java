import java.util.*;

public class Programmers_StringSort {
        public ArrayList<String> solution(String[] strings, int n) {

            ArrayList<Character> list = new ArrayList<>();
            HashMap<Character, ArrayList<String>> hm = new HashMap<>();
            ArrayList<String> answer = new ArrayList<>();

            for(int i=0;i<strings.length;i++){
                char c = strings[i].charAt(n);
                if(!list.contains(c)){
                    list.add(c);
                    hm.put(c, new ArrayList<String>());
                }
                ArrayList<String> llist = hm.get(c);
                llist.add(strings[i]);
                hm.put(c, llist);
            }
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                char c = list.get(i);
                ArrayList<String> newList = hm.get(c);
                Collections.sort(newList);
                for(int j=0;j<newList.size();j++){
                    answer.add(newList.get(j));
                }
            }

            return answer;
        }
}

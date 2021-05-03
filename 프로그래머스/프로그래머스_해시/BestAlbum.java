import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            hashMap.put(genres[i],hashMap.getOrDefault(genres[i],0)+plays[i]);
        }
        ArrayList<String> glist = new ArrayList<String>(hashMap.keySet());
        Collections.sort(glist, (o1, o2) -> (hashMap.get(o2).compareTo(hashMap.get(o1))));

        ArrayList<Integer> answers = new ArrayList<>();


        for(int i=0;i<glist.size();i++){
            int max=0;
            int index1=0;
            int index2=0;
            for(int j=0;j<genres.length;j++){
                if(glist.get(i).equals(genres[j])){

                    if(max<plays[j]){
                        max = plays[j];
                        index1 = j;
                    }
                }
            }

            max = 0;
            for(int j=0;j<genres.length;j++){
                if(glist.get(i).equals(genres[j])){

                    if(max<plays[j] && j!=index1){
                        max = plays[j];
                        index2 = j;
                    }
                }
            }

            answers.add(index1);
            if(max != 0){
                answers.add(index2);
            }
        }

        int[] answer = new int[answers.size()];
        for(int i=0;i<answers.size();i++){
            answer[i] = answers.get(i);
        }

        return answer;
    }
}

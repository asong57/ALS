import java.util.*;

public class Programmers_BestAlbum {
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<BestAlbum>> hm = new HashMap();
        for (int i = 0; i < genres.length; i++) {
            if (!hm.containsKey(genres[i])) {
                hm.put(genres[i], new ArrayList<>());
                ArrayList<BestAlbum> list = hm.get(genres[i]);
                list.add(new BestAlbum(i, plays[i]));
                hm.put(genres[i], list);
            } else {
                ArrayList<BestAlbum> list = hm.get(genres[i]);
                int play = plays[i];
                list.add(new BestAlbum(i, play));
                hm.put(genres[i], list);
            }
        }
        ArrayList<Answer> playSet = new ArrayList<>();
        for (String key : hm.keySet()) {
            int sum = 0;
            for (int j = 0; j < hm.get(key).size(); j++) {
                sum += hm.get(key).get(j).plays;
            }
            playSet.add(new Answer(key, sum));

        }
        Collections.sort(playSet, new Comparator<Answer>() {
            @Override
            public int compare(Answer o1, Answer o2) {
                return o2.sum - o1.sum;
            }
        });


        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < playSet.size(); i++) {
            Collections.sort(hm.get(playSet.get(i).genre), new Comparator<BestAlbum>() {
                @Override
                public int compare(BestAlbum o1, BestAlbum o2) {
                    if(o2.plays == o1.plays){
                        return o1.index - o2.index;
                    }
                    return o2.plays - o1.plays;
                }
            });
            if(hm.get(playSet.get(i).genre).size() >1){
                answerList.add(hm.get(playSet.get(i).genre).get(0).index);
                answerList.add(hm.get(playSet.get(i).genre).get(1).index);
            }else{
                answerList.add(hm.get(playSet.get(i).genre).get(0).index);
            }

        }
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] answer = solution(genres, plays);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}


class BestAlbum {
    int index;
    int plays;

    public BestAlbum(int i, int play) {
        this.index = i;
        this.plays = play;
    }
}

class Answer {
    String genre;
    int sum;

    public Answer(String genre, int sum) {
        this.genre = genre;
        this.sum = sum;
    }
}


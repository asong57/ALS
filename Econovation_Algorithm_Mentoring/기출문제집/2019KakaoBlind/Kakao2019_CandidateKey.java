import java.util.ArrayList;
import java.util.HashSet;

public class Kakao2019_CandidateKey {
    static String temp;
    static ArrayList<Integer> arr;
    static HashSet<String> key;
    static int answer;

    public static int solution(String[][] relation) {
        answer = 0;
        arr = new ArrayList<>();
        for (int i = 0; i < relation[0].length; i++) {
            arr.add(i);
        }

        key = new HashSet<>();
        for (int i = 1; i <= arr.size(); i++) {
            int[] test = new int[i];
            makeCombination(i, test, 0, 0, arr, relation);
        }

        return answer;
    }

    private static void makeCombination(int r, int[] now, int current, int start, ArrayList<Integer> arr, String[][] relation) {
        if (r == current) {
            String str = "";
            for (int i = 0; i < now.length; i++) {
                str += now[i];
            }
            temp = str;
            checkTuple(relation);
        } else {
            for (int i = start; i < arr.size(); i++) {
                now[current] = arr.get(i);
                makeCombination(r, now, current + 1, i + 1, arr, relation);
            }
        }
    }

    public static void checkTuple(String[][] relation) {
        String[] keys = key.toArray(new String[key.size()]);

        for (int i = 0; i < key.size(); i++) {
            String kkey = keys[i];
            int count = 0;
            for(int j=0;j<kkey.length();j++){
                if (temp.contains(kkey.charAt(j)+"")) {
                    count++;
                }else{
                    break;
                }
            }
            if(count == kkey.length()){
                return;
            }
        }
        HashSet<String> hs = new HashSet<>();
        String[] str = temp.split("");
        boolean isCandidate = true;

        for (int j = 0; j < relation.length; j++) {
            String check = "";
            for (int k = 0; k < str.length; k++) {
                check += relation[j][Integer.parseInt(str[k])];
            }
            if (hs.contains(check)) {
                isCandidate = false;
                break;
            } else {
                hs.add(check);
            }
        }

        if (isCandidate) {
            answer++;
            key.add(temp);
        }
    }

    public static void main(String[] args) {
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        System.out.println(solution(relation));
    }
}

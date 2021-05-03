import java.util.HashMap;

public class Disguise {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String[] cloth : clothes) {
            hashMap.put(cloth[1], hashMap.getOrDefault(cloth[1], 0) + 1);
        }

        for (String key : hashMap.keySet()) {
            answer *= hashMap.get(key) + 1;
        }

        return answer - 1;
    }
}

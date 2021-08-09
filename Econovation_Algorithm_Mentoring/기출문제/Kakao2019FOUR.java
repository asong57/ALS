import java.util.HashMap;
import java.util.HashSet;

public class Kakao2019FOUR {
    //호텔 방 배정

    //유니온 파인드로 해결 
    static HashMap<Long, Long> parent;
    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        parent = new HashMap<>();
        for(int j=0;j<room_number.length;j++){
            long parentNumber = find(room_number[j]);
           parent.put(parentNumber,parentNumber+1);
           answer[j] = parentNumber;
        }
        return answer;
    }
    public static long find(long a) {
        if (!parent.containsKey(a)){
            return a;
        }
        else{
            parent.put(a, find(parent.get(a)));
            return parent.get(a);
        }
    }

    //효율성 실패 (첫번째 풀이)
    public static long[] solutionFirst(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        HashSet<Long> hs = new HashSet<>();
        for (int i = 0; i < room_number.length; i++) {
            if (!hs.contains(room_number[i])) {
                answer[i] = room_number[i];
                hs.add(room_number[i]);
            } else {
                long index = room_number[i];
                while (hs.contains(index)) {
                    index++;
                }
                hs.add(index);
                answer[i] = index;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        long[] arr = {1, 3, 4, 1, 3, 1};
        long[] answer = solution(10, arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(answer[i]);
        }

    }
}

import java.util.HashSet;

public class Kakao2019FOUR {
    //호텔 방 배정패
    //효율성 실패

    public static long[] solution(long k, long[] room_number) {
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

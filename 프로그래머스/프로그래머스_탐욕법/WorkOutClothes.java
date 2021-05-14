import java.util.Arrays;

public class WorkOutClothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int lostNumber = lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    reserve[j] = -1;
                    lost[i] = -1;
                    lostNumber -= 1;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if ((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
                    lostNumber -= 1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        answer -= lostNumber;
        return answer;
    }
}

import java.util.Arrays;

public class Programmers_Immigration {
    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        // 이분탐색의 right 부분을 제대로 설정시킬 것
        long right = (long) n * times[times.length - 1];
        long mid = 0;
        long min = Integer.MAX_VALUE;
        // 굳이 따로 min 필요 없이 그대로 mid를 채택하면 된다..

        while (left <= right) {
            mid = (left + right) / 2;

            // 왠만하면 long을 다 취할 것
            long count = 0;
            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }

            if (count >= n) {
                right = mid - 1;
                min = mid;
            } else {
                left = mid + 1;
            }
        }
        answer = min;
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {7, 10};
        System.out.println(solution(6, arr));
    }
}

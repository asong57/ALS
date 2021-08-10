public class Kakao2019FIVE {
    //징검다리 건너기

    static long end = Integer.MAX_VALUE;
    static long mid = 0;
    static int count = 1;
    static long start = 1;
    static long max = 0;

    public static int solution(int[] stones, int k) {

        while (start <= end) {
            mid = (start + end) / 2;
            count = 1;
            check(stones, k);
        }

        return (int) max + 1;
    }

    public static void check(int[] stones, int k) {
        for (int i = 0; i < stones.length; i++) {
            if (count > k) {
                end = mid - 1;
                return;
            }

            if ((stones[i] - mid) <= 0) {
                count++;
            } else {
                count = 1;
            }

        }
        if (count > k) {
            end = mid - 1;
            return;
        }

        max = Math.max(max, mid);
        start = mid + 1;
    }

    //효율성 실패 (첫번째 풀이)
    public static int solutionFirst(int[] stones, int k) {
        int friend = 0;
        int jump = 1;
        while (jump <= k) {
            jump = 1;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] == 0) {
                    jump++;
                    if (jump > k) {
                        return friend;
                    }
                } else {
                    jump = 1;
                    stones[i]--;
                }

            }
            friend++;
        }
        return friend;
    }

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(solution(stones, 3));
    }
}

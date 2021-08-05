public class Kakao2019FIVE {
    //징검다리 건너기
    //효율성 실패

    public static int solution(int[] stones, int k) {
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

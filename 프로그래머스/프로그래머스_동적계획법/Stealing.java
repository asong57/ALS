public class Stealing {
    public int solution(int[] money) {
        int answer = 0;
        int[] dp = new int[money.length - 1];
        int[] dp2 = new int[money.length];

        dp[0] = money[0];
        dp[1] = money[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(money[i] + dp[i - 2], dp[i - 1]);
        }
        dp2[0] = 0;
        dp2[1] = money[1];
        for (int i = 2; i < dp2.length; i++) {
            dp2[i] = Math.max(money[i] + dp2[i - 2], dp2[i - 1]);
        }
        answer = Math.max(dp[dp.length - 1], dp2[dp2.length - 1]);
        return answer;
    }
}

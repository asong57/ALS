public class BiggestSquare {
    //dp 문제

    public int solution(int[][] board) {
        int answer;
        int[][] dp = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dp[i + 1][j + 1] = board[i][j];
            }
        }
        int max = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (dp[i][j] == 1) {
                    int left = dp[i - 1][j];
                    int up = dp[i][j - 1];
                    int leftUp = dp[i - 1][j - 1];
                    int min = Math.min(left, Math.min(up, leftUp));
                    dp[i][j] = min + 1;
                    max = Math.max(max, min + 1);
                }
            }
        }
        answer = max * max;
        return answer;
    }
}

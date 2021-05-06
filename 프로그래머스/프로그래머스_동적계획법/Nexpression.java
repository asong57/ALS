public class Nexpression {
    int answer;

    public int solution(int N, int number) {
        answer = 9;
        dfs(0, 0, N, number);
        return answer > 8 ? -1 : answer;
    }

    private void dfs(int count, int number, int N, int target) {
        if (count > 8) {
            return;
        }

        if (number == target) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 1; i <= 8 - count; i++) {
            dfs(count + i, number + getDigit(i, N), N, target);
            dfs(count + i, number - getDigit(i, N), N, target);
            dfs(count + i, number * getDigit(i, N), N, target);
            dfs(count + i, number / getDigit(i, N), N, target);

        }
    }

    private int getDigit(int digit, int N) {
        int result = 0;
        for (int i = 0; i < digit; i++) {
            result += Math.pow(10, i) * N;
        }
        return result;
    }
}

public class Programmers_FindPrimeNumber {
    public int solution(int n) {
        int answer = 1;
        l:
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                continue l;
            }
            for (int j = 3; j <= Math.sqrt(i); j += 2) {
                if (i % j == 0) {
                    continue l;
                }
            }
            answer++;
        }
        return answer;
    }
}

public class JumpAndMomentMoving {
    public int solution(int n) {
        int count = 0;

        while (n > 0) {
            if (n % 2 != 0) {
                count += 1;
                n -= 1;
            }
            if (n != 0) {
                n /= 2;
            }
        }

        return count;
    }
}

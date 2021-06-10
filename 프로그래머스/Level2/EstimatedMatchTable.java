public class EstimatedMatchTable {
    public static int solution(int n, int a, int b) {
        int count = 1;
        while ((a - 1) / 2 != (b - 1) / 2) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(16, 2, 10));
    }
}

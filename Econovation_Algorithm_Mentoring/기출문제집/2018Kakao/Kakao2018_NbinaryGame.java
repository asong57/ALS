public class Kakao2018_NbinaryGame {
    public static String solution(int n, int t, int m, int p) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        int num = 1;
        sb.append("0");
        while (sb.length() < m * t) {
            sb.append(changeNumber(num++, n));
        }
        for (int i = p - 1; i < m * (t - 1) + p; i += m) {
            answer += sb.charAt(i);
        }
        return answer;
    }

    public static String changeNumber(int num, int n) {
        String str = "";
        while (num > 0) {
            if (num % n < 10) {
                str = (num % n) + str;
            } else {
                str = String.valueOf((char) (num % n + 55)) + str;
            }

            num = num / n;
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
    }
}

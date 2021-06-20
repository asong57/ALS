import java.util.Locale;

public class NDecimalGame {
    //모든 진수에 대응하자..!
    
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        int count = 0;
        if (n == 2) {
            for (int i = 0; ; i++) {
                str = Integer.toBinaryString(i).toUpperCase();
                for (int j = 0; j < str.length(); j++) {
                    count++;
                    if (p - 1 == (count + 1) % m) {
                        answer += str.charAt(j) + "";
                    }
                    if (count == (t - 1) * m + p) {
                        return answer;
                    }
                }
            }
        } else if (n == 8) {
            for (int i = 0; ; i++) {
                str = Integer.toOctalString(i).toUpperCase();
                for (int j = 0; j < str.length(); j++) {
                    count++;
                    if (p - 1 == (count + 1) % m) {
                        answer += str.charAt(j) + "";
                    }
                    if (count == (t - 1) * m + p) {
                        return answer;
                    }
                }
            }
        } else if (n == 16) {
            for (int i = 0; ; i++) {
                str = Integer.toHexString(i).toUpperCase();
                for (int j = 0; j < str.length(); j++) {
                    count++;
                    if (p - 1 == (count + 1) % m) {
                        answer += str.charAt(j) + "";
                    }
                    if (count == (t - 1) * m + p) {
                        return answer;
                    }
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 1));
    }
}

public class StringCompaction {
    public static int solution(String s) {
        int min = s.length();
        String temp = "";
        String next = "";
        for (int i = 1; i <= s.length() / 2; i++) {
            int count = 1;
            String str = "";
            for (int j = 0; j < s.length() - i; j += i) {
                temp = s.substring(j, j + i);
                if (j + i + i >= s.length()) {
                    next = s.substring(j + i);
                } else {
                    next = s.substring(j + i, j + i + i);
                }
                if (temp.equals(next)) {
                    count++;
                } else {
                    if (count != 1) {
                        str += count + temp;
                    } else {
                        str += temp;
                    }
                    count = 1;
                }
            }
            if (count == 1) {
                str += next;
            } else {
                str += count + temp;
            }
            min = Math.min(min, str.length());
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcabcabcdededededede"));
    }
}

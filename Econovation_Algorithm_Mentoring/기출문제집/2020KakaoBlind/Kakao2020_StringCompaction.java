public class Kakao2020_StringCompaction {
    public static int solution(String s) {
        int answer = 0;
        int size = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String before = s.substring(0, i);
            String temp = "";
            int count = 1;
            String str = before;
            for (int j = i; j < s.length(); j += i) {
                if (j + i < s.length()) {
                    temp = s.substring(j, j + i);
                } else {
                    temp = s.substring(j);
                }

                if (temp.equals(before)) {
                    count++;
                } else {
                    if (count != 1) {
                        str = str + String.valueOf(count) + temp;
                    } else {
                        str = str + temp;
                    }
                    count = 1;
                    before = temp;
                }
            }
            if (count != 1) {
                str += count;
            }
            size = Math.min(str.length(), size);
        }
        answer = size;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("xababcdcdababcdcd"));
    }
}

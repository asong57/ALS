public class JadenCase {
    //- 대문자를 만드는 String 메소드: str.toUpperCase()
    //- 소문자로 만드는 String 메소드: str.toLowerCase()

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isEmptyNext = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 || isEmptyNext) {
                answer.append(Character.toUpperCase(c));
                isEmptyNext = false;
            } else {
                answer.append(Character.toLowerCase(c));
            }
            if (c == ' ') {
                isEmptyNext = true;
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
    }
}

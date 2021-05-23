import java.util.Arrays;
import java.util.Collections;

public class StringDecendingOrder {
    public static String solution(String s) {
        String[] arr = s.split("");
        Arrays.sort(arr, Collections.reverseOrder());

        return String.join("", arr); //배열 원소를 합쳐 String으로 만드는 메소드
    }

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }
}

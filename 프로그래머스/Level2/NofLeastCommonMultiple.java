import java.util.Arrays;

public class NofLeastCommonMultiple {
    //유클리드 호제법으로 최대공약수 구하기
    public static int gcd(int a, int b) {
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        while (x % y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return y;
    }

    public static int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int gcd = gcd(answer, arr[i]);
            answer = answer * arr[i] / gcd;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 50};
        System.out.println(solution(arr));
    }
}

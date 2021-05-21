public class OneTwoFourCountry {
    //- 단순해 보이는 문제였지만 풀이과정이 빠르게 생각나지 않는 문제였다.
    //- 수학적인 규칙을 찾아서 풀어야 하는 부분이었다.
    //- 입력이 엄청 큰 숫자일 경우 일일이 조합을 생각하는 것은 비효율적이다.
    //- 문자열을 더하는 순서대로 뒤로 가게 하려면
    //    - answer = numbers[n%3] + answer;로 하면 된다.

    public static void main(String[] args) {
        System.out.println(solution(6));
    }

    public static String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};
        while (n > 0) {
            answer = numbers[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }

}

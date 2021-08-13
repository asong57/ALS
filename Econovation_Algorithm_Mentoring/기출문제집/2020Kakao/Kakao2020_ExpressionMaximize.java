import java.util.ArrayList;

public class Kakao2020_ExpressionMaximize {
    static long answer;
    static ArrayList<Long> numbers;
    static ArrayList<Character> ops;
    static char[] o = {'*', '-', '+'};
    static boolean[] visited;

    public static long solution(String expression) {
        numbers = new ArrayList<>();
        ops = new ArrayList<>();
        visited = new boolean[3];

        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num += expression.charAt(i);
            } else {
                numbers.add(Long.parseLong(num));
                ops.add(expression.charAt(i));
                num = "";
            }
        }
        numbers.add(Long.parseLong(num));
        char[] temp = new char[3];
        permutaion(0, temp);

        return answer;
    }

    public static long calculate(long num1, long num2, char ops) {
        if (ops == '*') {
            return num1 * num2;
        }
        if (ops == '-') {
            return num1 - num2;
        }
        if (ops == '+') {
            return num1 + num2;
        }
        return 0;
    }

    public static void permutaion(int n, char[] temp) {
        if (n == 3) {
            ArrayList<Long> pNumbers = new ArrayList<>(numbers);
            ArrayList<Character> pOps = new ArrayList<>(ops);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < pOps.size(); j++) {
                    if (pOps.get(j) == temp[i]) {
                        long sum = calculate(pNumbers.remove(j), pNumbers.remove(j), pOps.remove(j));
                        pNumbers.add(j, sum);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(pNumbers.get(0)));
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[n] = o[i];
                permutaion(n + 1, temp);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }
}

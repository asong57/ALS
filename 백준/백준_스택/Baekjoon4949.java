import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.charAt(0) == '.') {
                break;
            }
            sb.append(solve(input)).append("\n");
        }
        System.out.print(sb);
    }

    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // i 번째 문자

            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {

                if (stack.empty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if (c == ']') {

                if (stack.empty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }

        }
        if (stack.empty()) {
            return "yes";
        } else {
            return "no";
        }


    }
}

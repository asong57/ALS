import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < str.length(); j++) {
                if (!stack.isEmpty() && stack.peek() == str.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(str.charAt(j));
                }
            }
            if (stack.size() == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}

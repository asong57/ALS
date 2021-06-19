
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Baekjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력할 결과물 저장
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int start = 0;

        while (N-- > 0) {
            int value = Integer.parseInt(br.readLine());
            if (value > start) {

                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = value;
            }

            else if (stack.peek() != value) {
                System.out.println("NO");
                return; // 또는 System.exit(0); 으로 대체해도 됨.
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}

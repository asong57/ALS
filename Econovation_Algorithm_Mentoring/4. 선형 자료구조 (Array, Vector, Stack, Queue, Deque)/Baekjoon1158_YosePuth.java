import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon1158_YosePuth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            stack.add(i);
        }
        int index = 0;
        while (!stack.isEmpty()) {
            index += (k - 1);


            if (index >= n) {
                index = index % n;
                sb.append(stack.remove(index));
            } else {
                sb.append(stack.remove(index));
            }
            n--;
            if (n > 0) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb.toString());
    }
}

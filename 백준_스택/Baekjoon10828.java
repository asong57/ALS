import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon10828 {
    private static int[] stack;
    private static int top = -1;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        stack = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "top":
                    top();
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int num) {
        stack[++top] = num;
    }

    public static void pop() {
        if (top == -1) {
            sb.append(-1).append("\n");
        } else {
            sb.append(stack[top]).append("\n");
            stack[top--] = 0;
        }
    }

    public static void size() {
        sb.append(top+1).append("\n");
    }

    public static void empty() {
        if (top == -1) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    public static void top() {
        if (top == -1) {
            sb.append(-1).append("\n");
        } else {
            sb.append(stack[top]).append("\n");
        }
    }
}

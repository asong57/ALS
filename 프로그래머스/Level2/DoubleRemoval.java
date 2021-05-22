import java.util.HashSet;
import java.util.Stack;

public class DoubleRemoval {
    //- list나 해시셋을 생각해서 풀기도 하고, 그냥 charAt비교로 풀어보았는데 효율성체크를 다 통과하지 못했다.
    //- 결국은 스택으로 푸는 문제였다. 그래야 효율성테스트를 통과할 수 있다.
    //- 가장 기본적인 자료구조인 스택을 사용할 것!
    
    public static void main(String[] args) {
        System.out.println(solution("aabaab"));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        stack.add(s.charAt(0));
        int i = 1;
        while (i < s.length()) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
            i++;
        }
        if (stack.size() > 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int solution2(String s) {
        int i = 0;
        while (i < s.length() - 1) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                s = s.substring(0, i) + s.substring(i + 2);
                ;
                i = 0;
            } else {
                i++;
            }
        }
        if (s.length() > 0) {
            return 0;
        } else {
            return 1;
        }
    }
}

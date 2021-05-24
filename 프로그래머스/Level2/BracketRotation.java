import java.util.Stack;

public class BracketRotation {
    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (checkBracket(s)) {
                answer++;
            }
            s = s.substring(1, s.length()) + s.substring(0, 1);
        }
        return answer;
    }

    public static boolean checkBracket(String s) {
        if (s.charAt(0) == '}' || s.charAt(0) == ')' || s.charAt(0) == ']') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        try{
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '}'){
                    if(stack.peek() != '{'){
                        return false;
                    }
                    stack.pop();
                }else if(c == ']'){
                    if(stack.peek() != '['){
                        return false;
                    }
                    stack.pop();
                }else if(c == ')'){
                    if(stack.peek() != '('){
                        return false;
                    }
                    stack.pop();
                }else {
                    stack.add(c);
                }
            }
        }catch (Exception e){
            return false;
        }finally {
            if(stack.size()>0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("}]()[{"));
    }
}

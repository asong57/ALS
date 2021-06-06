import java.util.Stack;

public class RightBracket {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.add(s.charAt(i));
            }else if(!stack.isEmpty()){
                stack.pop();
            }
        }

        if(stack.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}

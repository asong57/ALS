import java.util.Stack;

public class MakingBigNumber {
    //- 정렬 없이 원하는 자릿수만큼의 큰 수를 만들어야 한다.
    //- 총 길이에서 k개를 뺀 만큼 반복하고, 일정 범위 안에서의 가장 큰수를 찾고, 그 다음 부터 또 최소한으로 뽑아야 하는 범위 안에서 큰 수를 찾아 더하는 방식이 있다.
    //- 스택을 이용하는 방식도 있다.

    public String solution(String number, int k) {
        int pos = 0;
        char max;
        StringBuilder sb =new StringBuilder();
        for(int i=0; i< number.length()-k;i++){
            max = '0';
            for(int j=pos; j<= i+k;j++){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    pos = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }

    public String usingStack(String number, int k){
        String answer ="";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<number.length();i++){
            while(!stack.empty() && stack.peek() <number.charAt(i) && k-- >0){
                stack.pop();
            }
            stack.add(number.charAt(i));
        }
        for(int i=0;i<stack.size();i++){
            answer += stack.get(i);
        }
        return answer;
    }
}

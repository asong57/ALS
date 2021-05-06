import java.util.Stack;

public class CraneDollGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i< moves.length;i++){
            for(int j=0; j<board.length;j++){
                int top = board[j][moves[i]-1];
                if(top !=0){
                    if(stack.size()>=1){
                        if(stack.peek() == top){
                            stack.pop();
                            answer += 2;
                        }else{
                            stack.add(top);
                        }
                    }else {
                        stack.add(top);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}

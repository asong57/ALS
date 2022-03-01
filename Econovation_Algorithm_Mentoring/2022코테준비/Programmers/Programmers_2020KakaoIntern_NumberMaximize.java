import java.util.*;

public class Programmers_2020KakaoIntern_NumberMaximize {
    static long answer;
    static ArrayList<Long> numbers;
    static ArrayList<Character> ops;
    static char[] o = {'*', '-', '+'};
    static boolean[] visited;

    public static long solution(String expression) {
        numbers = new ArrayList<>();
        ops = new ArrayList<>();
        visited = new boolean[3];

        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num += expression.charAt(i);
            } else {
                numbers.add(Long.parseLong(num));
                ops.add(expression.charAt(i));
                num = "";
            }
        }
        numbers.add(Long.parseLong(num));
        char[] temp = new char[3];
        makePermutation(0, temp);

        return answer;
    }
    public  static void makePermutation(int count, char[] temp){
        if(count == 3){
            ArrayList<Long> pnumbers = new ArrayList<>(numbers);
            ArrayList<Character> pOps = new ArrayList<>(ops);
            long sum = 0;

            for(int i=0;i<3;i++){
                for(int j=0;j<pOps.size();j++){
                    if(pOps.get(j) == temp[i]){
                        sum = calculate(pnumbers.remove(j), pnumbers.remove(j), pOps.remove(j));
                        pnumbers.add(j,sum);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(pnumbers.get(0)));
        }else{
            for(int i=0;i<3;i++){
                if(visited[i] != true){
                    visited[i] = true;
                    temp[count] = o[i];
                    makePermutation(count+1, temp);
                    visited[i] = false;
                }

            }
        }
    }

    public static long calculate(long a, long b, char c){
        if(c == '*'){
            return a*b;
        }else if (c == '-'){
            return a-b;
        }else{
            return a+b;
        }
    }
}
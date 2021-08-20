import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Kakao2021_TableEdit {
    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();

        int temp = k;
        int table_size = n;
        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].charAt(0) == 'U') {
                temp -= Integer.parseInt(cmd[i].substring(2));
                continue;
            }

            if (cmd[i].charAt(0) == 'D') {
                temp += Integer.parseInt(cmd[i].substring(2));
                continue;
            }

            if (cmd[i].charAt(0) == 'C') {
                stack.add(temp);
                table_size--;
                if(temp == table_size){
                    temp--;
                }
                continue;
            }

            if (cmd[i].charAt(0) == 'Z') {
              int r =  stack.pop();
              if(temp >= r){
                  temp++;
              }
              table_size++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<table_size;i++)
        {
            sb.append('O');
        }
        while(!stack.isEmpty()){
            sb.insert(stack.pop().intValue(), 'X');
        }
        answer = sb.toString();
        return answer;
    }

    //정확성, 효율성 다 좋지 않았떤,,,
    public static String solution2(int n, int k, String[] cmd) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(i);
            list.add(i);
        }

        int temp = k;
        ArrayList<Integer> deleteList = new ArrayList<>();

        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].charAt(0) == 'U') {
                temp -= cmd[i].charAt(2) - '0';
                continue;
            }

            if (cmd[i].charAt(0) == 'D') {
                temp += cmd[i].charAt(2) - '0';
                continue;
            }

            if (cmd[i].charAt(0) == 'C') {

                deleteList.add(0, list.remove(temp));
                pq.remove(temp);

                if (temp == pq.size()) {
                    temp--;
                }
                continue;
            }

            if (cmd[i].charAt(0) == 'Z') {
                pq.add(deleteList.get(0));
                deleteList.remove(0);

                if (deleteList.get(0) <= list.get(temp)) {
                    temp++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (pq.contains(i)) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        System.out.println(solution(8, 2, cmd));
    }
}

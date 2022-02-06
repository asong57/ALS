public class Programmers_NArrayCut {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        int cnt = 0;
        while(left<=right) {
            int row = (int)(left/n)+1;
            answer[cnt++] = (int)Math.max(row, left%n+1);
            left++;
        }
        return answer;
    }
}

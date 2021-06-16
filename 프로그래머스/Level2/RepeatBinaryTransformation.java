public class RepeatBinaryTransformation {

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int zero = 0;

        while(!s.equals("1")){
            int c = s.replaceAll("0","").length();
            zero += s.length()-c;
            s = Integer.toBinaryString(c);
            cnt++;
        }
        answer[0] = cnt;
        answer[1] = zero;
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution("1111111")[0]);
    }
}

public class NDecimalGame2 {
    //- 각 진법에 맞게 나누고 나머지들을 String에 저장하고,
    //- 숫자 i마다 진법을 바꾼 String들을 합치고 이 중 charAt()에서 튜브 순서에만 answer에 추가하면 된다.

    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        // 게임
        int i = 1;
        sb.append(0);
        while(sb.length()<m*t) {
            sb.append(notation(i++,n));
        }
        // 튜브가 말해야 하는 숫자
        for(int j=p-1; j<m*(t-1)+p; j+=m) {
            answer += sb.charAt(j);
        }
        return answer;
    }

    // 진법 변환
    String notation(int num, int n) {
        String nStr = "";
        while(num!=0) {
            if(num%n<10)
                nStr = num%n + nStr;
            else // 10진수 이상 알파벳 저장
                nStr = String.valueOf((char)(num%n + 55)) + nStr;
            num /= n;
        }
        return nStr;
    }
}

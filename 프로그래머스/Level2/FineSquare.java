public class FineSquare {
    //좌표를 연상하고, 일차함수 그래프를 약간 활용하여 푸는 문제
    public long solution(long w, long h) {
        long answer = 0;

        for(int i=0; i<w; i++) {
            answer += h*i/w ;
        }

        return answer * 2;
    }
}

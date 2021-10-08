public class Programmers_MINRectangle {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0] < sizes[i][1]){
                int n = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = n;
            }
        }
        int max0 =0;
        int max1 = 0;
        for(int i=0;i<sizes.length;i++){
            max0 = Math.max(max0, sizes[i][0]);
            max1 = Math.max(max1, sizes[i][1]);
        }

        answer = max0 * max1;
        return answer;
    }
}

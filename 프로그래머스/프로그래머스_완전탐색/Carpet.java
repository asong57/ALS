public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=0;i<brown/2;i++){
            for(int j=0;j<brown/2;j++) {
                if ((brown + yellow == i * j) && ((i * 2) + (j - 2) * 2 == brown) && ((i - 2) * (j - 2) == yellow)) {
                    answer = new int[]{i, j};
                }
            }
        }
        return answer;
    }
}

public class Programmars_DartGame {
    public static int solution(String dartResult) {
        int answer = 0;
        int now = 0;
        int[] numbers = new int[3];
        numbers[0]= -1;
        numbers[1] = -1;
        numbers[2] = -1;
        int index = -1;

        for(int i=0;i<dartResult.length();i++){
            char c = dartResult.charAt(i);
            if(c == 'S'){
                continue;
            }
            if(c == 'D'){
                numbers[index] = numbers[index] * numbers[index];
                continue;
            }
            if(c == 'T'){
               numbers[index] = numbers[index] * numbers[index] * numbers[index];
                continue;
            }
            if(c == '*'){
                if(index > 0){
                    numbers[index -1 ] = numbers[index-1] * 2;
                }
                numbers[index] = numbers[index] * 2;
                continue;
            }
            if(c == '#'){
                numbers[index] = -1 * numbers[index];
                continue;
            }
            now = c - '0';

            if(i > 0 && now == 0 && dartResult.charAt(i-1) - '0' == 1){
                now = 10;
                numbers[index] = now;
            }else{
                index++;
                numbers[index] = now;
            }
        }

        answer = numbers[0] + numbers[1] + numbers[2];
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution("1D2S#10S"));
    }
}

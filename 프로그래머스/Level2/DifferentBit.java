public class DifferentBit {
    //두 케이스에서 시간초과 발생
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            answer[i] = f(numbers[i]);
        }
        return answer;
    }
    public static long f(long number){
        String bit = Long.toBinaryString(number);
        long next = number+1;
        String nextBit = Long.toBinaryString(next);
        while(true){
            int count = 0;
            if(nextBit.length() != bit.length()){
                bit = "0"+bit;
            }
            for(int i=nextBit.length()-1;i>=0;i--){
                char c2 = nextBit.charAt(i);
                char c1 = bit.charAt(i);
                if(c1 != c2){
                    count++;
                }
                if(count >2){
                    break;
                }
            }
            if(count >2){
                next++;
                nextBit = Long.toBinaryString(next);
            }
            if(count <=2){
                return next;
            }
        }
    }
    public static void main(String[] args){
        long[] numbers = {2,7};
        System.out.println(solution(numbers)[0]+" "+ solution(numbers)[1]);;
    }
}

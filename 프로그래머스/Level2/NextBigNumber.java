public class NextBigNumber {
    public int solution(int n) {
        int nextCount = 0;
        int count  = 0;
        String nBinary = Integer.toBinaryString(n);
        for(int i=0; i< nBinary.length();i++){
            if(nBinary.charAt(i) == '1'){
                count++;
            }
        }
        while(count != nextCount ){
            n++;
            nextCount = 0;
            String nextBinary = Integer.toBinaryString(n);
            for(int i=0;i<nextBinary.length();i++){
                if(nextBinary.charAt(i) == '1'){
                    nextCount++;
                }
            }
        }
        return n;
    }

    //num 숫자를 binary로 변환후, 1의 수를 반환
    public int nextBigNumber(int n)
    {
        int a = Integer.bitCount(n);
        int compare = n+1;

        while(true) {
            if(Integer.bitCount(compare)==a)
                break;
            compare++;
        }

        return compare;
    }
}

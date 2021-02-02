import java.io.*;

public class Baekjoon1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int one;
        int ten;
        int second=0;
        int sum;
        int count=0;
        int number =Integer.parseInt(br.readLine().trim());
        int inputNumber = number;
        while(true){
            if(number <10){
                one=number;
                ten=0;
            }
            one = number%10;
            ten = number/10;
            sum = one+ten;
            second = one*10+sum%10;
            number = second;
            count++;
            if(number == inputNumber){
                bw.write(String.valueOf(count));
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}


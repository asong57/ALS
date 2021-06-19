import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine().trim();
        StringTokenizer st = new StringTokenizer(number);
        String num1 = st.nextToken();
        String num2 = st.nextToken();

        int number1 = num1.charAt(0)-'0'+(num1.charAt(1)-'0')*10+(num1.charAt(2)-'0')*100;
        int number2 = num2.charAt(0)-'0'+(num2.charAt(1)-'0')*10+(num2.charAt(2)-'0')*100;
        System.out.println(number1>number2?number1:number2);
    }
}

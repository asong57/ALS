import java.io.*;

public class Baekjoon11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine().trim());
        String numbers = br.readLine();
        int sum=0;
        for(int i=0; i<number; i++){
            sum+=numbers.charAt(i)-'0';
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}

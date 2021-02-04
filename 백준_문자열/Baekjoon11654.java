import java.io.*;

public class Baekjoon11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char word = br.readLine().charAt(0);
        bw.write(String.valueOf((int)word));

        bw.flush();
        bw.close();
    }
}

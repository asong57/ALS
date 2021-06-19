import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String text;
        StringTokenizer st;

        while((text=br.readLine()) != null && text.length() !=0 ){

            st = new StringTokenizer (text);

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write(A+B+"\n");
        }
        bw.flush();
        bw.close();
    }
}
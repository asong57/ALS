import java.io.*;
import java.util.StringTokenizer;

public class CodeUp1086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double w = Integer.parseInt(st.nextToken());
        double h = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());

        double save = w*h*b/8/1024/1024;
        System.out.printf("%.2f MB", save);
    }
}

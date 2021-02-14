import java.io.*;
import java.util.StringTokenizer;

public class CodeUp1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double h = Integer.parseInt(st.nextToken());
        double b = Integer.parseInt(st.nextToken());
        double c = Integer.parseInt(st.nextToken());
        double s = Integer.parseInt(st.nextToken());
        double save = h*b*c*s/8/1024/1024;
        System.out.printf("%.1f MB", save);
    }
}

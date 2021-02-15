import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long answer=a;
        for(int i=1;i<n;i++){
            answer = answer * m +d;
        }
       System.out.printf("%d", answer);
    }
}

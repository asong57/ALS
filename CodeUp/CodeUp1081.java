import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1081 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers);
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        for(int i=1;i<=num1;i++){
            for(int j=1;j<=num2;j++){
                System.out.println(i+" "+j);
            }
        }
    }
}

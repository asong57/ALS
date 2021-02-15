import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeUp1095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers);
        int[] call = new int[n];

        for(int j=0;j<n;j++){
            call[j] = Integer.parseInt(st.nextToken());
        }
        int big=call[0];
        for (int i =1; i <n; i++) {
          if(call[i] < big){
              big = call[i];
          }
        }
        System.out.print(big);
    }
}

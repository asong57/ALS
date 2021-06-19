import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                //dp[i]는 arr[i]보다 작은 원소 중에서 가장 큰 dp에 1을 더한다.
                if(arr[j] < arr[i] && dp[i] <dp[j] +1){
                    dp[i] = dp[j] +1;
                }
            }
        }

        int max = -1;
        for(int i=0; i<n;i++){
            max = dp[i] > max ? dp[i] :max;
        }
        System.out.print(max);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = 0;

        int min = Integer.MAX_VALUE;
        while (left < n) {
            if (arr[right] - arr[left] < m) {
                right++;
                if (right == n) {
                    left++;
                    right = left;
                }
                continue;
            } else if (arr[right] - arr[left] >= m) {
                min = Math.min(arr[right] - arr[left], min);
                left++;
                right = left;
                if (right == n) {
                    left++;
                    right = left;
                }
            }
        }
        System.out.println(min);
    }
    public void twopointer(int right, int left, int[] inputArr, int N, int M, int minValue){
        //그냥 right가 n보다 작은 경우를 while문으로 해서 하면 된다. 따로 left, right 설정하지 않아도 된다.
        while(right <= N) {
            int diff = inputArr[right] - inputArr[left];

            if(diff > M) {
                minValue = Math.min(minValue, diff);
                left++;
            }else if(diff == M) {
                minValue = M;
                break;
            }else{
                right++;
            }
        }
    }
}

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int n2 = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] B=new int[n2];
        for (int i = 0; i < n2; i++) {
            B[i]=Integer.parseInt(st2.nextToken());
        }
        for (int i = 0; i < n2; i++) {
            bw.write(String.valueOf(BinarySearch(B[i],A))+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int BinarySearch(int target, int[] A) {
        Arrays.sort(A);
        int left = 0;
        int right = A.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (A[mid] == target) {
                return 1;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else if (A[mid] > target) {
                right = mid - 1;
            }
        }
        return 0;
    }
}

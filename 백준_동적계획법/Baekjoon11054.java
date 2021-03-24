import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11054 {

    static int n;
    static int[] arr;
    static int[] rdp;
    static int[] ldp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        rdp = new int[n];
        ldp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        LIS();
        LDS();

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < ldp[i] + rdp[i]) {
                max = ldp[i] + rdp[i];
            }
        }
        System.out.print(max - 1);


    }

    static void LIS() {
        for (int i = 0; i < n; i++) {
            rdp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && rdp[i] < rdp[j] + 1) {
                    rdp[i] = rdp[j] + 1;
                }
            }
        }
    }

    static void LDS() {
        for (int i = n - 1; i >= 0; i--) {
            ldp[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && ldp[i] < ldp[j] + 1) {
                    ldp[i] = ldp[j] + 1;
                }
            }
        }
    }
}

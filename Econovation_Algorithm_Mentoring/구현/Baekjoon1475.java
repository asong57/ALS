import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        while (n > 0) {
            int num = n % 10;
            n = n / 10;
            if (num == 6 || num == 9) {
                if (arr[6] > arr[9]) {
                    arr[9]++;
                } else if (arr[6] < arr[9]) {
                    arr[6]++;
                } else {
                    arr[num]++;
                }
            } else {
                arr[num]++;
            }
        }
        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }
}

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1913_Snail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int max = size * size;
        int count = 1;
        int originalSize = size;
        int[][] arr = new int[size][size];
        int i = -1;
        int j = 0;

        while (true) {
            for (int t = 1; t <= size; t++) {
                i += count;
                arr[i][j] = max;
                max--;
            }
            size--;
            if (size <= 0) {
                break;
            }
            for (int t = 1; t <= size; t++) {
                j += count;
                arr[i][j] = max;
                max--;
            }
            count *= -1;
        }
        int x = 0;
        int y = 0;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < arr.length; k++) {
            for (int h = 0; h < arr.length; h++) {
                sb.append(arr[k][h]);
                if (arr[k][h] == n) {
                    x = k + 1;
                    y = h + 1;
                }
                if (h == arr.length - 1) {
                    sb.append("\n");
                } else {
                    sb.append(" ");
                }
            }
        }
        sb.append(x + " " + y);
        System.out.println(sb.toString());
    }
}

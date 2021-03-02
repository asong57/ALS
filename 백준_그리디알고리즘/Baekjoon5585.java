import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5585 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = 1000 - Integer.parseInt(br.readLine());
        int[] money = {500, 100, 50, 10, 5, 1};
        int count = 0;
        for (int i = 0; i < money.length; i++) {

            if (money[i] <= change) {
                count += change / money[i];
                change %= money[i];
            }
        }
        System.out.print(count);
    }
}

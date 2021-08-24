import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon1038_DescendingNumber {
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        if (n <= 10) {
            System.out.println(n);
        } else if (n > 1022) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < 10; i++) {
                Cal(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(n));
        }

    }

    private static void Cal(long num, int depth) {
        if (depth > 10) {
            return;
        }
        list.add(num);

        for (int i = 0; i < 10; i++) {
            if (num % 10 > i) {
                Cal((num * 10) + i, depth + 1);
            }
        }
        return;
    }
}

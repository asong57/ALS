import java.util.Scanner;

public class Baekjoon2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        String result = Integer.toString(A * B * C);
        int[] results = new int[result.length()];
        int[] counts = new int[10];
        for (int i = 0; i < result.length(); i++) {
            results[i] = Integer.parseInt(result.substring(i, i + 1));
        }

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < result.length(); i++) {
                if (results[i] == j) {
                    counts[j]++;
                }
            }
        }
        for (int j = 0; j < 10; j++) {
            System.out.println(counts[j]);
        }
    }
}

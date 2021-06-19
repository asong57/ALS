import java.util.Scanner;

public class Baekjoon2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String[] letters = new String[number];
        int[] counts = new int[number];
        String result = "";

        for (int i = 0; i < number; i++) {
            counts[i] = sc.nextInt();
            letters[i] = sc.next();
        }

        for (int a = 0; a < letters.length; a++) {
            for (int n = 0; n < letters[a].length(); n++) {
                for (int k = 0; k < counts[a]; k++) {

                    result += letters[a].substring(n, n + 1);
                }
            }
            System.out.println(result);
            result = "";
        }
    }
}


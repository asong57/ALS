import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String firstPeterPan = ".#..";
        String firstWendy = ".*..";
        String secondPeterPan = ".#.#";
        String secondWendy = ".*.*";

        StringBuilder sb = new StringBuilder();
        sb.append(".");
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("#");
        for (int i = 1; i <= input.length(); i++) {
            sb3.append(".").append(input.charAt(i - 1)).append(".");
            if (i % 3 != 0) {
                sb.append(firstPeterPan);
                sb2.append(secondPeterPan);

            } else {
                sb.append(firstWendy);
                sb2.append(secondWendy);
            }

            if (i % 3 == 1) {
                sb3.append("#");
            } else {
                if (i == input.length() && i % 3 == 2) {
                    sb3.append("#");
                } else {
                    sb3.append("*");
                }
            }
        }
        sb2.append(".");
        System.out.println(sb.toString());
        System.out.println(sb2.toString());
        System.out.println(sb3.toString());
        System.out.println(sb2.toString());
        System.out.println(sb.toString());

    }
}

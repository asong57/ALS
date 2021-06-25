import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }

        String answer = "";
        for (int i = 0; i < input[0].length(); i++) {
            boolean check = true;
            char c = input[0].charAt(i);

            for (int j = 0; j < n-1; j++) {
                if (input[j].charAt(i) != input[j+1].charAt(i)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                answer += c;
            } else {
                answer += "?";
            }
        }
        System.out.println(answer);
    }
}

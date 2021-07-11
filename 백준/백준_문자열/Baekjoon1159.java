import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            hm.put(str.charAt(0), hm.getOrDefault(str.charAt(0), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : hm.keySet()) {
            if (hm.get(c) >= 5) {
                sb.append(c + "");
            }
        }
        if (sb.length() == 0) {
            System.out.println("PREDAJA");
            return;
        }
        System.out.println(sb.toString());
    }
}

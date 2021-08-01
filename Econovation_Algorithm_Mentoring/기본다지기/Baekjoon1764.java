import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (hs.contains(str)) {
                list.add(str);
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)).append("\n");
        }
        System.out.print(sb.toString());
    }
}

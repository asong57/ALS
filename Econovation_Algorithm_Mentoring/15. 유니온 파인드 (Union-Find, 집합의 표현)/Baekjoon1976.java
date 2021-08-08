import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1976 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int check = Integer.parseInt(st.nextToken());
                if (check == 1) {
                    union(i, j);
                }
            }
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int plan = Integer.parseInt(st2.nextToken());
        int parentCheck = find(plan - 1);
        while (st2.hasMoreTokens()) {
            plan = Integer.parseInt(st2.nextToken());
            if (find(plan - 1) != parentCheck) {
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");
    }

    public static int find(int a) {
        if (parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10775 {
    //공항
    
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        parent = new int[g + 1];
        for (int j = 1; j <= g; j++) {
            parent[j] = j;
        }
        int count = 0;

        for (int i = 1; i <= p; i++) {
            int gate = Integer.parseInt(br.readLine());
            int emptyGate = find(gate);
            if (emptyGate == 0) {
                break;
            }
            count++;
            union(emptyGate, emptyGate - 1);
        }
        System.out.println(count);
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
            parent[a] = b;
    }
}

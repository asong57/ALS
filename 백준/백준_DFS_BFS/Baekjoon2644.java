import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int rn = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> relation = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            relation.add(new ArrayList<>());
        }

        for (int i = 0; i < rn; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            relation.get(n1).add(n2);
            relation.get(n2).add(n1);
        }
        bfs(relation, p1, p2);

    }

    public static void bfs(ArrayList<ArrayList<Integer>> relation, int p1, int p2) {
        Queue<Person> q = new LinkedList<>();
        q.add(new Person(p1, 0));
        boolean isFind = false;

        boolean[] isVisited = new boolean[relation.size()];
        isVisited[p1] = true;
        while (!q.isEmpty()) {
            Person person = q.poll();
            int now = person.n;
            if (now == p2) {
                isFind = true;
                System.out.println(person.cnt);
                return;
            }
            for (int i = 0; i < relation.get(now).size(); i++) {
                int next = relation.get(now).get(i);
                if (!isVisited[next]) {
                    q.add(new Person(next, person.cnt + 1));
                    isVisited[next] = true;
                }

            }
        }

        if (!isFind) {
            System.out.println(-1);
        }
    }
}

class Person {
    int n;
    int cnt;

    public Person(int n, int cnt) {
        this.n = n;
        this.cnt = cnt;
    }
}
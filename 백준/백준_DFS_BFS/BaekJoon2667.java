import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BaekJoon2667 {
    //dfs 복습 문제
    //이상하게 StringTokenizer가 안 되서 그냥 .charAt(i) - '0' 으로 char를 숫자로 바꾸었다.
    static int[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] map = new int[num][num];
        String input;
        for (int i = 0; i < num; i++) {
            input = br.readLine();
            for (int j = 0; j < num; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        visit = new int[num][num];
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                cnt = 1;
                if (map[i][j] != 0 && visit[i][j] == 0) {
                    dfs(map, i, j, num);
                    sum++;
                    list.add(cnt);
                }
            }
        }
        System.out.println(sum);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int[][] map, int i, int j, int num) {
        visit[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int xx = i + dx[k];
            int yy = j + dy[k];
            if (xx < 0 || xx >= num || yy < 0 || yy >= num) {
                continue;
            }
            if (visit[xx][yy] == 1) {
                continue;
            }
            if (map[i][j] == map[xx][yy]) {
                cnt++;
                dfs(map, xx, yy, num);
            }

        }
    }
}

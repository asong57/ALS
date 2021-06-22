import java.util.ArrayList;
import java.util.List;

public class Friends4Block {
    char[][] map;
    int answer = 0;

    public int solution(int m, int n, String[] board) {
        map = new char[m][n];

        //char배열로 초기화
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }

        //갱신될 것이 없을 때까지 반복
        while (updateBlocks(m, n)) ;

        return answer;
    }

    public boolean updateBlocks(int m, int n) {
        boolean[][] c = new boolean[m][n];
        int cnt = 0;

        //4개가 같은 것들 boolean배열로 체크
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == '0') continue;
                if (check(i, j) == true) {
                    c[i][j] = true;
                    c[i][j + 1] = true;
                    c[i + 1][j] = true;
                    c[i + 1][j + 1] = true;
                }
            }
        }

        //true로 체크된 것들 count
        //false인 것들 리스트에 넣어서 char배열에 쭉 넣어주고 남은 곳에 '0' 넣기
        for (int i = 0; i < n; i++) {
            List<Character> temp = new ArrayList<>();
            for (int j = m - 1; j >= 0; j--) {
                if (c[j][i] == true) {
                    cnt++;
                    continue;
                }
                temp.add(map[j][i]);
            }
            for (int j = m - 1, k = 0; j >= 0; j--, k++) {
                if (k < temp.size()) map[j][i] = temp.get(k);
                else map[j][i] = '0';
            }
        }
        answer += cnt;
        return cnt > 0 ? true : false;
    }

    //4개가 같은지 확인
    public boolean check(int i, int j) {
        char std = map[i][j];
        if (map[i][j + 1] == std && map[i + 1][j] == std && map[i + 1][j + 1] == std) {
            return true;
        } else {
            return false;
        }
    }
}

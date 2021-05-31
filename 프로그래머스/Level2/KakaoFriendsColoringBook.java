import java.util.ArrayList;

public class KakaoFriendsColoringBook {
    //- 다양한 풀이방법이 있지만 dfs로 해결해보았다.
    //- visit[][]을 사용하는 것 잊지 않고,
    //- 상하좌우 dx = {0,1,-1,0}, dy ={} 이런식으로 움직이고
    //- 조건들을 잘 체크하며 상하좌우 dfs로 방문체크하며 풀이하기!

    static int[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cnt;

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (visit[i][j] == 0 && picture[i][j] != 0) {
                    cnt = 1;
                    dfs(m, n, picture, i, j);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void dfs(int m, int n, int[][] picture, int i, int j) {
        visit[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int xx = i + dx[k];
            int yy = j + dy[k];
            if(xx < 0 || yy < 0 || xx >=m || yy >= n){
                continue;
            }
            if(visit[xx][yy] != 0)continue;
            if(picture[xx][yy] == picture[i][j]){
                cnt++;
                dfs(m,n,picture,xx,yy);
            }
        }
    }

    public static void main(String[] args) {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        System.out.println(solution(6, 4, picture)[0]);
        System.out.println(solution(6, 4, picture)[1]);
    }

}

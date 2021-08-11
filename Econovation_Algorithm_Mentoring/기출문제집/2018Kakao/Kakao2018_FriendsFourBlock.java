import java.util.ArrayList;

public class Kakao2018_FriendsFourBlock {
    //프렌즈4블럭
    public static int solution(int m, int n, String[] board) {
        if (m <= 1) {
            return 0;
        }
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }

        boolean isUpdate = true;
        boolean[][] isVisited;
        int count = 0;

        while (isUpdate) {
            isUpdate = false;
            isVisited = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j] == ' ') {
                        continue;
                    }
                    if (arr[i][j] == arr[i + 1][j] && arr[i][j] == arr[i][j + 1] && arr[i][j] == arr[i + 1][j + 1]) {
                        isUpdate = true;
                        if (!isVisited[i][j]) {
                            isVisited[i][j] = true;
                            count++;
                        }
                        if (!isVisited[i + 1][j]) {
                            isVisited[i + 1][j] = true;
                            count++;
                        }

                        if (!isVisited[i][j + 1]) {
                            isVisited[i][j + 1] = true;
                            count++;
                        }
                        if (!isVisited[i + 1][j + 1]) {
                            isVisited[i + 1][j + 1] = true;
                            count++;
                        }
                    }
                }
            }


            for (int i = 0; i < n; i++) {
                ArrayList<Character> list = new ArrayList<>();
                for (int j = m - 1; j >= 0; j--) {
                    if (!isVisited[j][i]) {
                        list.add(arr[j][i]);
                    }
                }
                for (int k = m - 1, s = 0; k >= 0; k--) {
                    if (s < list.size()) {
                        arr[k][i] = list.get(s);
                        s++;
                    } else {
                        arr[k][i] = ' ';
                    }
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String[] board = {"AAAAA", "AUUUA", "AUUAA", "AAAAA"};
        System.out.println(solution(4, 5, board));
    }
}

public class Kakao2021_DistanceCheck {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            char[][] arr = new char[5][5];
            for (int j = 0; j < places[i].length; j++) {
                for (int k = 0; k < 5; k++) {
                    arr[j][k] = places[i][j].charAt(k);
                }
            }
            answer[i] = checkDistance(arr);
        }
        return answer;
    }

    public static int checkDistance(char[][] arr) {
        int answer = 1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == 'P') {
                    for (int k = 0; k < 4; k++) {
                        int xx = i + dx[k];
                        int yy = j + dy[k];
                        if (xx >= 0 && yy >= 0 && xx < 5 && yy < 5) {
                            if (arr[xx][yy] == 'X') {
                                continue;
                            }
                            if (arr[xx][yy] == 'P') {
                                return 0;
                            }
                            for (int h = 0; h < 4; h++) {
                                if (h != k && h % 2 == k % 2) {
                                    continue;
                                }
                                int hx = xx + dx[h];
                                int hy = yy + dy[h];
                                if (hx >= 0 && hy >= 0 && hx < 5 && hy < 5) {
                                    if (arr[hx][hy] == 'X') {
                                        continue;
                                    }
                                    if (arr[hx][hy] == 'P') {
                                        return 0;
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}

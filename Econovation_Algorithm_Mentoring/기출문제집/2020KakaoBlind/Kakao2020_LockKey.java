public class Kakao2020_LockKey {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int n = lock.length;
        int m = key.length;

        int map[][] = new int[n + 2 * (m - 1)][n + 2 * (m - 1)];
        int temp[][] = new int[map.length][map.length];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[m - 1 + i][m - 1 + j] = lock[i][j];
            }
        }

        for (int i = 0; i <= map.length - m; i++) {
            for (int j = 0; j <= map.length - m; j++) {
                l:
                for (int k = 0; k < 4; k++) {
                    key = rotate(key);
                    temp = setMap(map);

                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < m; y++) {
                            if (temp[i + x][j + y] == 1 && key[x][y] == 1) {
                                continue l;
                            } else if (temp[i + x][j + y] == 0 && key[x][y] == 1) {
                                temp[i + x][j + y] = 1;
                            }
                        }
                    }
                    if (check(temp, n, m)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static int[][] rotate(int key[][]) {
        int len = key.length;
        int convert[][] = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                convert[j][len - i - 1] = key[i][j];
            }
        }
        return convert;
    }

    public static int[][] setMap(int map[][]) {
        int len = map.length;
        int convert[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            convert[i] = map[i].clone();
        }
        return convert;
    }

    public static boolean check(int map[][], int n, int m) {
        for (int i = m - 1; i < n + m - 1; i++) {
            for (int j = m - 1; j < n + m - 1; j++)
                if (map[i][j] == 0)
                    return false;
        }

        return true;
    }
}

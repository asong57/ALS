public class TriangleSnail {
    //아래, 오른쪽, 왼쪽을 돌아가면서 배열을 계속 채워나가는 문제
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] arr = new int[n][n];
        int nn = n;
        int count = 1;
        int row = -1;
        int col = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                row++;
                arr[row][col] = count;
                count++;
            }
            if (n == 1) break;
            n--;
            for (int i = 0; i < n; i++) {
                col++;
                arr[row][col] = count;
                count++;
            }
            if (n == 1) break;
            n--;
            for (int i = 0; i < n; i++) {
                row--;
                col--;
                arr[row][col] = count;
                count++;
            }
            if (n == 1) break;
            n--;
        }
        int k = 0;
        for (int i = 0; i < nn; i++) {
            for (int j = 0; j < nn; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                answer[k] = arr[i][j];
                k++;
            }
        }
        return answer;
    }
}

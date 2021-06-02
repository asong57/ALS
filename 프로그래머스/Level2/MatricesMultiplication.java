public class MatricesMultiplication {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int n = 0; n < arr1[0].length; n++) {
                    answer[i][j] += (arr1[i][n] * arr2[n][j]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        int[][] answer = solution(arr1, arr2);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.println(answer[i][j]);
            }
        }
    }
}

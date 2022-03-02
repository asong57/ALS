public class Programmers_TiredValue {
    static int max = 0;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int[] arr = new int[dungeons.length];

        for (int i = 0; i < dungeons.length; i++) {
            arr[i] = i;
        }
        int size = dungeons.length;
        visited = new boolean[size];
        makePermutation(0, new int[size], arr, k, dungeons);
        answer = max;
        return answer;
    }

    public void makePermutation(int n, int temp[], int[] arr, int k, int[][] dungeons) {
        int now = k;
        int count = 0;

        if (n == temp.length) {
            for (int i = 0; i < temp.length; i++) {
                if (dungeons[temp[i]][0] > now) {
                    return;
                } else {
                    count++;
                    now -= dungeons[temp[i]][1];
                    max = Math.max(count, max);
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp[n] = arr[i];
                    makePermutation(n + 1, temp, arr, k, dungeons);
                    visited[i] = false;
                }
            }
        }
    }
}

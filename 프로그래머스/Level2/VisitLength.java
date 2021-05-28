import java.util.HashSet;

public class VisitLength {
    //- 방문했는지를 체크할 때 양쪽에서의 상황을 다 체크해야 한다는 것까지는 알았는데 어떻게 코드로 해야할 지 몰랐다.
    //- 4차원 배열을 이용하니 바로 해결이 되었다!
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }

    public static int solution(String dirs) {
        int answer = 0;
        int x = 5;
        int y = 5;
        int[][][][] arr = new int[11][11][11][11];
        for (int i = 0; i < dirs.length(); i++) {
            if (dirs.charAt(i) == 'U') {
                if (y != 10) {
                    if (arr[x][y][x][y + 1] != 1 && arr[x][y + 1][x][y] != 1) {
                        arr[x][y][x][y + 1] = 1;
                        arr[x][y + 1][x][y] = 1;
                        answer++;
                    }
                    y++;
                }
                continue;
            } else if (dirs.charAt(i) == 'D') {
                if (y != 0) {
                    if (arr[x][y][x][y - 1] != 1 && arr[x][y - 1][x][y] != 1) {
                        arr[x][y][x][y - 1] = 1;
                        arr[x][y - 1][x][y] = 1;
                        answer++;
                    }
                    y--;
                }
                continue;
            } else if (dirs.charAt(i) == 'R') {
                if (x != 10) {
                    if (arr[x][y][x + 1][y] != 1 && arr[x + 1][y][x][y] != 1) {
                        arr[x + 1][y][x][y] = 1;
                        arr[x][y][x + 1][y] = 1;
                        answer++;
                    }
                    x++;
                }
                continue;
            } else if (dirs.charAt(i) == 'L') {
                if (x != 0) {
                    if (arr[x][y][x - 1][y] != 1 && arr[x - 1][y][x][y] != 1) {
                        arr[x - 1][y][x][y] = 1;
                        arr[x][y][x - 1][y] = 1;
                        answer++;
                    }
                    x--;
                }
                continue;
            }
        }
        return answer;
    }

}

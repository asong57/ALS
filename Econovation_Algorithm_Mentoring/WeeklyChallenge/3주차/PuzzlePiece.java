import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PuzzlePiece {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    ArrayList<Point> boardList;
    HashMap<String, Point> hm;
    int count;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        // 같은 bfs 메소드를 쓰기 위해서 0과 1의 의미를 통일시킴.
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board.length; j++) {
                if (game_board[i][j] == 0) {
                    game_board[i][j] = 1;
                } else {
                    game_board[i][j] = 0;
                }
            }
        }

        hm = new HashMap<>();

        //값이 1일 때 bfs 시작
        // bfs를 통해 얻은 해시맵의 키 값에 개수와 크기를 저장한다.
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[0].length; j++) {
                if (game_board[i][j] == 1) {
                    String blockString = bfs(i, j, game_board);
                    Point bp = hm.getOrDefault(blockString, new Point(0, count));
                    bp.x++;
                    hm.put(blockString, bp);
                }
            }
        }

        // 퍼즐 조각의 방향을 바꿔가면서 해시맵과 일치하는 것이 있는지 체크한다.
        // 마찬가지로 1일 때 bfs메소드를 돌리고 해시맵의 키값을 얻어낸다.
        // 키값이 이미 존재하는 경우에 테이블 값을 0으로 만들어서 다시 카운트하지 않도록 한다.
        // 조각의 크기만큼 answer에 더해준다.
        // 개수가 0이 되면 해시맵에서 키를 제거한다. 아니면 값을 하나 줄여서 넣어준다.
        for (int k = 0; k < 4; k++) {
            table = changeDirection(table);
            int[][] temptable = new int[table.length][table.length];
            for (int d = 0; d < table.length; d++)
                temptable[d] = table[d].clone();

            for (int i = 0; i < temptable.length; i++)
                for (int j = 0; j < temptable.length; j++)
                    if (temptable[i][j] == 1) {
                        String blockString = bfs(i, j, temptable);
                        if (hm.containsKey(blockString)) {
                            for (Point bp : boardList)
                                table[bp.x][bp.y] = 0;
                            Point p = hm.get(blockString);
                            answer += p.y;
                            if (--p.x == 0)
                                hm.remove(blockString);
                            else
                                hm.put(blockString, p);
                        }
                    }
        }

        return answer;
    }

    // 배열 방향 돌리는 메소드
    public int[][] changeDirection(int[][] table) {
        int[][] arr = new int[table.length][table.length];
        int size = table.length - 1;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                int row = j;
                int col = table.length - 1 - i;
                arr[i][j] = table[row][col];
            }
        }

        return arr;
    }

    // 배열의 1인 값들을 따라가는 bfs로, 그 값들의 사각형 크기를 잰다.
    // count로 총 값들의 크기를 센다.
    // boardList로 각 좌표 또한 저장한다.
    public String bfs(int x, int y, int[][] board) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        board[x][y] = 0;
        int n = board.length;
        int maxX = 0;
        int maxY = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        count = 0;
        boardList = new ArrayList<>();

        while (!q.isEmpty()) {
            Point now = q.poll();

            maxX = Math.max(maxX, now.x);
            minX = Math.min(minX, now.x);
            maxY = Math.max(maxY, now.y);
            minY = Math.min(minY, now.y);
            boardList.add(new Point(now.x, now.y));
            count++;

            for (int i = 0; i < 4; i++) {
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];

                if (xx >= 0 && yy >= 0 && xx < n && yy < n && board[xx][yy] == 1) {
                    board[xx][yy] = 0;
                    q.add(new Point(xx, yy));
                }
            }
        }
        String str = makeString(minX, minY, maxX, maxY, boardList);
        return str;
    }

    // boardList에 저장해 둔 값과 bfs()에서 얻어온 사각형 크기를 통해 해시맵의 키를 만든다.
    public String makeString(int minX, int minY, int maxX, int maxY, ArrayList<Point> list) {
        int row = maxX - minX + 1;
        int col = maxY - minY + 1;
        int[][] arr = new int[row][col];
        for (int i = 0; i < list.size(); i++) {
            arr[list.get(i).x - minX][list.get(i).y - minY] = 1;
        }
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                str = str + arr[i][j];
            }
            str = str + "n";
        }
        return str;
    }
}

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

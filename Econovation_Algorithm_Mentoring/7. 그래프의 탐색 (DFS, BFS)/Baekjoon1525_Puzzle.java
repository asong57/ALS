import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1525_Puzzle {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        Queue<String> q=new LinkedList<>(); // BFS 돌리기 위함
        HashMap<String, Integer> map=new HashMap<>(); // 중복 체크

        for(int i=0;i<3;i++) {
            sb.append(br.readLine().replace(" ", ""));
        }

        if(sb.toString().equals("123456780")) // 이미 완성된 퍼즐
            System.out.println("0");
        else {
            map.put(sb.toString(), 0);
            q.offer(sb.toString());
            System.out.println(bfs(q, map));
        }
    }

    public static int bfs(Queue<String> q, HashMap<String, Integer> map) {
        int[] dotX= {0,1,0,-1};
        int[] dotY= {1,0,-1,0};

        while(!q.isEmpty()) {
            String str=q.poll();
            int zeroIdx=str.indexOf("0"); // 0 위치 찾기
            int row=zeroIdx/3; // map에서 행 위치
            int col=zeroIdx%3; // 열 위치

            for(int i=0;i<4;i++) { // 이동 가능한 범위 체크
                int xx=row+dotX[i];
                int yy=col+dotY[i];
                if(xx<0 || xx>=3 || yy<0 || yy>=3) continue;
                int swapIdx=3*xx+yy; // 2차원 인덱스를 1차원으로 변환

                // 0과 바꿀 자리를 swap
                StringBuilder sb=new StringBuilder(str);
                char ch=sb.charAt(swapIdx);
                sb.setCharAt(swapIdx, '0');
                sb.setCharAt(zeroIdx, ch);

                // 정답 찾음
                if(sb.toString().equals("123456780"))
                    return map.get(str)+1;

                // 새로 만들어진 문자열인 경우
                if(!map.containsKey(sb.toString())) {
                    q.offer(sb.toString()); // 큐에 넣어 나중에 다시 체크
                    map.put(sb.toString(), map.get(str)+1);
                }
            }
        }

        return -1;
    }
}

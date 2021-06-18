import java.util.HashMap;

public class GroupPhoto {
    //int 배열을 통해 순열을 만들어내는 방식
    
    static int[] position;
    static int count;
    static boolean[] visited;
    static HashMap<Character, Integer> kakao;
    static boolean ok;

    public static int solution(int n, String[] data) {
        count = 0;
        position = new int[8];
        visited = new boolean[8];
        kakao = new HashMap<>();
        ok = true;
        visited = new boolean[8];

        kakao.put('A', 0);
        kakao.put('C', 1);
        kakao.put('F', 2);
        kakao.put('J', 3);
        kakao.put('M', 4);
        kakao.put('N', 5);
        kakao.put('R', 6);
        kakao.put('T', 7);

        perm(0, data);

        return count;
    }

    public static void perm(int idx, String[] data) {
        if (idx == 8) {
            if (isOk(data)) {
                count++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                position[idx] = i;
                perm(idx + 1, data);
                visited[i] = false;
            }
        }
    }

    static boolean isOk(String[] data) {
        for (int i = 0; i < data.length; i++) {
            int x = kakao.get(data[i].charAt(0));
            int y = kakao.get(data[i].charAt(2));
            char type = data[i].charAt(3);
            int diff = data[i].charAt(4) - '0';
            int xpos = position[x];
            int ypos = position[y];
            int index = Math.abs(xpos - ypos) - 1;

            if (type == '<') {
                if (index >= diff) {
                    return false;
                }
            }
            if (type == '>') {
                if (index <= diff) {
                    return false;
                }
            }
            if (type == '=') {
                if (index != diff) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(solution(2, data));
    }
}


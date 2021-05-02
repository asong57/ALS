import java.util.LinkedList;
import java.util.Queue;

public class WordChange {
    static class Node {
        int edge;
        String word;

        public Node(int edge, String word) {
            this.edge = edge;
            this.word = word;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.add(new Node(0, begin));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.word.equals(target)) {
                answer = now.edge;
                break;
            }
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && wordCheck(now.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(now.edge + 1, words[i]));
                }
            }
        }

        return answer;
    }

    public static boolean wordCheck(String now, String next) {
        int count = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != next.charAt(i)) {
                count++;
            }
            if (count > 1)
                return false;
        }
        return true;
    }
}

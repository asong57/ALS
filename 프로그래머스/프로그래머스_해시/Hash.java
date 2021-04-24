import java.util.HashMap;

public class Hash {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hash = new HashMap<>();
        for (String player : participant) {
            if (hash.containsKey(player)) {
                hash.put(player, hash.get(player) + 1);
            } else {
                hash.put(player, 1);
            }
        }
        for (String winner : completion) {
            hash.put(winner, hash.get(winner) - 1);
        }
        for (String player : participant) {
            if (hash.get(player) != 0) {
                answer = player;
            }
        }
        return answer;
    }
}

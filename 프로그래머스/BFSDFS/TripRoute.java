import java.util.ArrayList;
import java.util.Collections;

public class TripRoute {
    boolean[] visited;
    String str = "";
    ArrayList<String> list = new ArrayList<String>();

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int size = tickets.length;
        visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (tickets[i][0].equals("ICN")) {
                visited[i] = true;
                str = "ICN,";
                dfs(tickets[i][1], 1, tickets);
                visited[i] = false;
            }
        }

        Collections.sort(list);
        answer = list.get(0).split(",");

        return answer;
    }

    public void dfs(String now, int count, String[][] tickets) {
        str += now + ",";
        if (count == tickets.length) {
            list.add(str);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                dfs(tickets[i][1], count + 1, tickets);
                visited[i] = false;
                str = str.substring(0, str.length() - 4);
            }
        }
    }

}

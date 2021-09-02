import java.util.*;

public class Kakao2019_OpenChattingRoom {
    public String[] solution(String[] record) {

        HashMap<String, String> hm = new HashMap();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            if (record[i].charAt(0) == 'E') {
                StringTokenizer st = new StringTokenizer(record[i]);
                st.nextToken();
                hm.put(st.nextToken(), st.nextToken());
                continue;
            } else if (record[i].charAt(0) == 'C') {
                StringTokenizer st = new StringTokenizer(record[i]);
                st.nextToken();
                hm.put(st.nextToken(), st.nextToken());
                continue;
            }
        }
        for (int i = 0; i < record.length; i++) {
            if (record[i].charAt(0) == 'E') {
                StringTokenizer st = new StringTokenizer(record[i]);
                st.nextToken();
                list.add(hm.get(st.nextToken()) + "님이 들어왔습니다.");
                continue;
            } else if (record[i].charAt(0) == 'C') {
                continue;
            } else if (record[i].charAt(0) == 'L') {
                StringTokenizer st = new StringTokenizer(record[i]);
                st.nextToken();
                list.add(hm.get(st.nextToken()) + "님이 나갔습니다.");
                continue;
            }
        }

        String[] answer = list.toArray(new String[list.size()]);

        return answer;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class NewsClustering {
    public static int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        char c1 = ' ';
        char c2 = ' ';
        String str = "";
        String s1 = "";
        String s2 = "";
        double count = 0;

        for (int i = 1; i < str1.length(); i++) {
            c1 = str1.charAt(i - 1);
            c2 = str1.charAt(i);
            if (c1 < 'a' || c1 > 'z' || c1 == ' ') {
                continue;
            }
            if (c2 < 'a' || c2 > 'z' || c2 == ' ') {
                continue;
            }
            s1 = String.valueOf(c1);
            s2 = String.valueOf(c2);
            str = s1 + s2;
            list1.add(str);
        }

        for (int i = 1; i < str2.length(); i++) {
            c1 = str2.charAt(i - 1);
            c2 = str2.charAt(i);
            if (c1 < 'a' || c1 > 'z' || c1 == ' ') {
                continue;
            }
            if (c2 < 'a' || c2 > 'z' || c2 == ' ') {
                continue;
            }
            s1 = String.valueOf(c1);
            s2 = String.valueOf(c2);
            str = s1 + s2;
            list2.add(str);
        }

        for (int i = 0; i < list1.size(); i++) {
            if (list2.contains(list1.get(i))) {
                count++;
            }
        }

        for (int i = 0; i < list2.size(); i++) {
            if (list1.contains(list2.get(i))) {
                list1.remove(list2.get(i));
            }
        }

        int size = list1.size() + list2.size();

        if (list1.size() == 0 && list2.size() == 0) {
            return 65536;
        }
        double r = count / size;
        answer = (int) (r * 65536);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("handshake", "shake hands"));
    }

}

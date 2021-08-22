import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Kakao2018_FileNameSort {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] file1 = split(o1);
                String[] file2 = split(o2);

                int headValue = file1[0].compareTo(file2[0]);

                if (headValue == 0) {
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);

                    return num1 - num2;
                } else {
                    return headValue;
                }
            }
        });
        answer = files;
        return answer;
    }

    private String[] split(String str) {
        String head = "";
        String number = "";
        String tail = "";
        int idx = 0;
        for (; idx < str.length(); ++idx) {
            char ch = str.charAt(idx);
            if (ch >= '0' && ch <= '9') {
                break;
            }
            head += ch;
        }

        for (; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if (!(ch >= '0' && ch <= '9')) {
                break;
            }
            number += ch;
        }
        for (; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            tail += ch;
        }
        String[] file = {head.toLowerCase(), number, tail};
        return file;
    }
}

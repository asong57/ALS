import java.util.Stack;

public class BracketTransition {
    //괄호 문제
    //문제에서 주어진 요구사항들을 그대로 구현해야 하는 문제

    public String solution(String p) {
        return makeCorrect(p);
    }

    String makeCorrect(String w) {
        if (w.length() == 0) {
            return "";
        }
        int cut = division(w);
        String u = w.substring(0, cut);
        String v = w.substring(cut, w.length());

        if (isCorrect(u)) {
            return u + makeCorrect(v);
        } else {
            String temp = "(" + makeCorrect(v) + ")";
            u = u.substring(1, u.length() - 1);
            u = reverse(u);
            return temp + u;
        }
    }

    int division(String w) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                return i + 1;
            }
        }
        return -1;
    }

    boolean isCorrect(String w) {
        int count = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    String reverse(String w) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        return sb.toString();
    }
}

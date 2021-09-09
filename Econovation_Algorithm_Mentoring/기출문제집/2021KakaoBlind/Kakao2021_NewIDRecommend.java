public class Kakao2021_NewIDRecommend {
    public static String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        String str = "";
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (c >= 'a' && c <= 'z') {
                str = str + c;
                continue;
            }
            if (c >= '0' && c <= '9') {
                str = str + c;
                continue;
            }
            if (c == '-' || c == '_' || c == '.') {
                str = str + c;
                continue;
            }
        }
        new_id = str;

        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        if (new_id.length() >= 1 && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }

        if (new_id.length() >= 1 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        if (new_id.length() == 0) {
            new_id = "a";
        }

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        if (new_id.length() <= 2) {
            while (new_id.length() < 3) {
                new_id = new_id + new_id.charAt(new_id.length() - 1);
            }
        }
        answer = new_id;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
    }
}

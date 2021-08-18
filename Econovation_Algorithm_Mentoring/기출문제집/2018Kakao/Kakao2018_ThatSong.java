public class Kakao2018_ThatSong {
    //방금 그 곡 
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        if (m.contains("C#")) {
            m = m.replaceAll("C#", "h");
        }
        if (m.contains("D#")) {
            m = m.replaceAll("D#", "i");
        }
        if (m.contains("F#")) {
            m = m.replaceAll("F#", "j");
        }
        if (m.contains("G#")) {
            m = m.replaceAll("G#", "k");
        }
        if (m.contains("A#")) {
            m = m.replaceAll("A#", "l");
        }

        for (int i = 0; i < musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            int startHour = Integer.parseInt(infos[0].substring(0, 2));
            int endHour = Integer.parseInt(infos[1].substring(0, 2));
            int startMinute = Integer.parseInt(infos[0].substring(3));
            int endMinute = Integer.parseInt(infos[1].substring(3));
            int length = 0;
            int hourDifference = endHour - startHour;
            length = endMinute - startMinute + hourDifference * 60;
            String music = infos[3];
            if (music.contains("C#")) {
                music = music.replaceAll("C#", "h");
            }
            if (music.contains("D#")) {
                music = music.replaceAll("D#", "i");
            }
            if (music.contains("F#")) {
                music = music.replaceAll("F#", "j");
            }
            if (music.contains("G#")) {
                music = music.replaceAll("G#", "k");
            }
            if (music.contains("A#")) {
                music = music.replaceAll("A#", "l");
            }
            String playedMusic = "";
            int index = 0;
            for (int j = 0; j < length; j++) {
                playedMusic += music.charAt(index);
                index++;
                if (index == music.length()) {
                    index = 0;
                }
            }

            if (playedMusic.contains(m)) {
                if (max < length) {
                    max = length;
                    answer = infos[2];
                }
            }
        }

        return answer;
    }

    //테스트케이스 25번만 통과 못했음..
    public static String solution2(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        for (int i = 0; i < musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            int startHour = Integer.parseInt(infos[0].substring(0, 2));
            int endHour = Integer.parseInt(infos[1].substring(0, 2));
            int startMinute = Integer.parseInt(infos[0].substring(3));
            int endMinute = Integer.parseInt(infos[1].substring(3));
            int length = 0;
            int hourDifference = endHour - startHour;
            length = endMinute - startMinute + hourDifference * 60;
            String music = "";
            int index = 0;
            for (int j = 0; j < length; j++) {
                music += infos[3].charAt(index);
                index++;
                if (index == infos[3].length()) {
                    index = 0;
                }
                if (j != length - 1 && infos[3].charAt(index) == '#') {
                    music += infos[3].charAt(index);
                    index++;
                }
                if (index == infos[3].length()) {
                    index = 0;
                }
            }
            if (music.contains(m)) {
                int check = music.lastIndexOf(m) + m.length();
                if (check < music.length() && music.charAt(check) == '#') {
                    continue;
                }
                if (length > max) {
                    max = length;
                    answer = infos[2];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution("ABC", musicinfos));
    }

}

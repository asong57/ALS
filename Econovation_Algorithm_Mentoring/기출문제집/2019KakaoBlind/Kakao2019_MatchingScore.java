import java.util.ArrayList;
import java.util.HashMap;

public class Kakao2019_MatchingScore {
    public static int solution(String word, String[] pages) {
        int answer = 0;
        double[][] scores = new double[pages.length][4];
        HashMap<String, Integer> hm = new HashMap<>();
        word = word.toLowerCase();
        HashMap<Integer, ArrayList<Integer>> linkHm = new HashMap<>();

        for (int i = 0; i < pages.length; i++) {
            /*
            int siteIndex = pages[i].indexOf("content=\"https://");
            String siteStr = pages[i].substring(siteIndex + 17);
            int siteLastIndex = siteStr.indexOf("\"");
            String site = siteStr.substring(0, siteLastIndex);*/
            String pageText = pages[i].toLowerCase();
            String site = getUrl(pageText);
            hm.put(site, i);
            ArrayList<Integer> list = new ArrayList<>();
            linkHm.put(i, list);
        }

        for (int i = 0; i < pages.length; i++) {
            String link = pages[i];
            while (link.contains("<a href=")) {
                int linkIndex = link.indexOf("<a href=");
                String linkStr = link.substring(linkIndex + 9);
                int linkLastIndex = linkStr.indexOf("\"");
                String finalLink = linkStr.substring(0, linkLastIndex);
                System.out.println(finalLink);
                link = linkStr.substring(linkLastIndex);
                scores[i][1]++;
                if (hm.containsKey(finalLink)) {
                    ArrayList<Integer> list = linkHm.get(hm.get(finalLink));
                    list.add(i);
                    linkHm.put(hm.get(finalLink), list);
                }
            }

            pages[i] = pages[i].toLowerCase();
            while (pages[i].contains(word)) {
                int wordIndex = pages[i].indexOf(word);
                if (wordIndex == 0) {
                    String wordStr = pages[i].substring(wordIndex + word.length());
                    pages[i] = wordStr;
                    continue;
                }
                if ((pages[i].charAt(wordIndex - 1) >= 'A') && (pages[i].charAt(wordIndex - 1) <= 'Z')) {
                    String wordStr = pages[i].substring(wordIndex + word.length());
                    pages[i] = wordStr;
                    continue;
                }
                if ((pages[i].charAt(wordIndex - 1) >= 'a') && (pages[i].charAt(wordIndex - 1) <= 'z')) {
                    String wordStr = pages[i].substring(wordIndex + word.length());
                    pages[i] = wordStr;
                    continue;
                }

                if ((pages[i].charAt(wordIndex + word.length()) >= 'A') && (pages[i].charAt(wordIndex + word.length()) <= 'Z')) {
                    String wordStr = pages[i].substring(wordIndex + word.length());
                    pages[i] = wordStr;
                    continue;
                }
                if ((pages[i].charAt(wordIndex + word.length()) >= 'a') && (pages[i].charAt(wordIndex + word.length()) <= 'z')) {
                    String wordStr = pages[i].substring(wordIndex + word.length());
                    pages[i] = wordStr;
                    continue;
                }

                String wordStr = pages[i].substring(wordIndex + word.length());
                pages[i] = wordStr;

                scores[i][0]++;
            }
        }

        for (int i = 0; i < pages.length; i++) {
            double sum = 0;
            for (int j = 0; j < linkHm.get(i).size(); j++) {
                if (scores[linkHm.get(i).get(j)][1] != 0) {
                    sum += scores[linkHm.get(i).get(j)][0] / scores[linkHm.get(i).get(j)][1];
                }
            }

            scores[i][2] = sum;
            scores[i][3] = scores[i][0] + scores[i][2];
        }
        double max = -1;
        for (int i = 0; i < scores.length; i++) {
            if (max < scores[i][3]) {
                max = scores[i][3];
                answer = i;
            }
        }
        return answer;
    }

    public static String getUrl(String page) {
        String urlText = "<meta property=\"og:url\" content=\"";
        int startPoint = page.indexOf(urlText) + urlText.length();
        int endPoint = page.indexOf("\"", startPoint);
        return page.substring(startPoint, endPoint);
    }

    public static void main(String[] args) {
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
        System.out.println(solution("muzi", pages));

    }
}

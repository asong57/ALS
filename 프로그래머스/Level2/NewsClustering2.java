import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class NewsClustering2 {
    static ArrayList<String> inter = new ArrayList<>();
    static ArrayList<String> union = new ArrayList<>();
    static ArrayList<String> arr1 = new ArrayList<>();
    static ArrayList<String> arr2 = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(solution("aa1+aa2", "AAAA12"));
    }

    public static int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for (int i = 0; i < str1.length() - 1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);

            if (ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'a' && ch2 <= 'z') {
                arr1.add(ch1 + "" + ch2);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);

            if (ch1 >= 'a' && ch1 <= 'z' && ch2 >= 'a' && ch2 <= 'z') {
                arr2.add(ch1 + "" + ch2);
            }
        }
        Collections.sort(arr1);
        Collections.sort(arr2);


        for (int i = 0; i < arr1.size(); i++) {
            String str = arr1.get(i);
            if (arr2.remove(str)) {
                inter.add(str);
            }
            union.add(str);
        }
        for (int i = 0; i < arr2.size(); i++) {
            String str = arr2.get(i);
            union.add(str);
        }

        double rs = 0;
        if (union.size() == 0)
            rs = 1;
        else
            rs = (double) inter.size() / (double) union.size();

        return (int) (rs * 65536);
    }
}
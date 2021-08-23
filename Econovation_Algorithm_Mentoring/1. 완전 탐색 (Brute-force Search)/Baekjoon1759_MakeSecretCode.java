import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1759_MakeSecretCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        String[] arr = new String[c];
        for (int i = 0; i < c; i++) {
            arr[i] = st2.nextToken();
        }
        Arrays.sort(arr);


        String[] temp = new String[l];
        makeCode(arr, temp, 0, l, 0);

    }

    public static void makeCode(String[] arr, String[] temp, int count, int l, int start) {
        if (count == l) {
            String str = "";
            Arrays.sort(temp);
            int v = 0;
            int c = 0;
            for (int i = 0; i < temp.length; i++) {
                str += temp[i];
                if (temp[i].equals("a") || temp[i].equals("e") || temp[i].equals("i") || temp[i].equals("o") || temp[i].equals("u")) {
                    v++;
                } else {
                    c++;
                }
            }
            if (v >= 1 && c >= 2) {
                System.out.println(str);
            }
            return;
        }

        for (int i = start; i < arr.length; i++) {
            temp[count] = arr[i];
            makeCode(arr, temp, count + 1, l, i + 1);
        }
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine().trim());
        double[] scores = new double[number];
        StringTokenizer st;
        String text = br.readLine();
        st = new StringTokenizer(text);
        for (int i = 0; i < number; i++) {
            scores[i] = Double.parseDouble(st.nextToken());
        }
        double max = scores[0];
        for (int i = 1; i < number; i++) {
            if (max < scores[i]) {
                max = scores[i];
            }
        }
        double[] newScores = new double[number];
        double sum = 0;
        for (int i = 0; i < number; i++) {
            newScores[i] = scores[i] * 100.0/max;
            sum += newScores[i];
        }
        bw.write(String.valueOf(sum / number));
        bw.flush();
        bw.close();
    }
}

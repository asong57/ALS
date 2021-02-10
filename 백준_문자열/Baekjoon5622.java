import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        String[] dial = words.split("");
        String word;
        int sum = 0;
        for (int i = 0; i < dial.length; i++) {
            word = dial[i];
            if (word.equals("A") || word.equals("B") || word.equals("C")) {
                sum += 3;
            } else if (word.equals("D") || word.equals("E") || word.equals("F")) {
                sum += 4;
            } else if (word.equals("G") || word.equals("H") || word.equals("I")) {
                sum += 5;
            } else if (word.equals("J") || word.equals("K") || word.equals("L")) {
                sum += 6;
            } else if (word.equals("M") || word.equals("N") || word.equals("O")) {
                sum += 7;
            } else if (word.equals("P") || word.equals("Q") || word.equals("R") || word.equals("S")) {
                sum += 8;
            } else if (word.equals("T") || word.equals("U") || word.equals("V")) {
                sum += 9;
            } else if (word.equals("W") || word.equals("X") || word.equals("Y") || word.equals("Z")) {
                sum += 10;
            }
        }
        System.out.println(sum);
    }
}

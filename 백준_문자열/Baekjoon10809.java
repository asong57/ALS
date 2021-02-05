import java.io.*;

public class Baekjoon10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        String[] words = word.split("");
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int[] numbers = new int[26];
        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[j].equals(alphabet[i])) {
                    numbers[i] = j;
                    break;
                } else {
                    numbers[i] = -1;
                }
            }
            bw.write(String.valueOf(numbers[i])+" ");
        }
        bw.flush();
        bw.close();
    }
}

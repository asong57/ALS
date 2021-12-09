import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String word = br.readLine();
        int count = 0;
        input = input.replaceAll(word, "1");
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == '1'){
                count++;
            }
        }
        System.out.println(count);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        l : for(int i=0;i<n;i++){
            String word = br.readLine();
            HashSet<Character> hs = new HashSet<>();
            char before = '?';
            for(int j=0;j<word.length();j++){
                char c = word.charAt(j);
                if(before != c){
                    if(hs.contains(word.charAt(j))){
                        continue l;
                    }else{
                        hs.add(word.charAt(j));
                        before = c;
                    }
                }

            }
            count++;
        }
        System.out.println(count);
    }
}

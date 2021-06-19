import java.io.*;

public class Baekjoon1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int[] count = new int[26];

        for(int i=0; i< word.length();i++){
            if(word.charAt(i)>=65 && word.charAt(i)<=90){
                count[word.charAt(i)-65]++;
            }else{
                count[word.charAt(i)-97]++;
            }
        }
        int max =-1;
        char maxLetter = '?';

        for(int i=0;i< count.length;i++){
            if(max<count[i]){
                max=count[i];
                maxLetter=(char)(i+65);
            }else if(max == count[i]){
                maxLetter='?';
            }
        }

      System.out.println(maxLetter);
    }
}

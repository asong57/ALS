import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i=0;i<str.length()-1;i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i) < str.charAt(j)){
                    str = str.substring(0,i)+str.substring(j,j+1)+str.substring(i+1,j)+str.substring(i,i+1)+str.substring(j+1);
                }
            }
        }
        System.out.println(str);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int sum=0;
        int line =0;
        while(number>sum){
            line++;
            sum = line * (line+1) / 2;
        }
        if(line % 2 !=0){
            int top = 1 + sum - number;
            int bottom = line - (sum - number);
            System.out.println(top+"/"+bottom);
        }else{
            int top = line - (sum - number);
            int bottom = 1 + sum - number;
            System.out.println(top + "/" + bottom);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1087 {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int number = Integer.parseInt(br.readLine());
    int sum=0;
    int i=1;
    while(sum<number){
        sum+=i;
        i++;
    }
    System.out.println(sum);
}
}

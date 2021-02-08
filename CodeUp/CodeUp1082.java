import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        int num = Integer.parseInt(numbers, 16);
        for(int i=1;i<16;i++){
            System.out.print(String.format("%X*%X=%X\n",num,i,num*i));
        }
    }
}

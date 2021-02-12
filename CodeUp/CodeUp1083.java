import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeUp1083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        for(int i=1;i<=number;i++){
            if(Integer.toString(i).equals("3") || Integer.toString(i).equals("6") || Integer.toString(i).equals("9")){
                System.out.print("X"+" ");
            }else {
                System.out.print(i + " ");
            }
        }
    }
}

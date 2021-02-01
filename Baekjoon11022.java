import java.io.*;

public class Baekjoon11022 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());
        for(int i=1;i<=number;i++){
            String text = br.readLine();
            String[] word=text.split(" ");
            int a=Integer.parseInt(word[0]);
            int b=Integer.parseInt(word[1]);
            bw.write("Case #"+i+": "+a+" + "+b+" = "+(a+b)+"\n");
        }
        bw.flush();
        bw.close();
    }
}

import java.io.*;

public class Baekjoon10952 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String text = br.readLine();
            String[] word = text.split(" ");
            int a =Integer.parseInt(word[0]);
            int b = Integer.parseInt(word[1]);
            if(a==0 && b==0){break;}
            bw.write((a+b)+"\n");
        }
        bw.flush();
        bw.close();
    }
}

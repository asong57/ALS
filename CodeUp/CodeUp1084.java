import java.io.*;
import java.util.StringTokenizer;

public class CodeUp1084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int r = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count =0;
        for(int i=0;i<r;i++){
            for(int j = 0; j<g;j++){
                for(int k=0;k<b;k++){
                   bw.write(i+" "+j+" "+k+"\n");
                    count++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}

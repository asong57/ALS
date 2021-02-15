import java.io.*;
import java.util.StringTokenizer;

public class CodeUp1098 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split(" ");
        int h = Integer.parseInt(str[0]);
        int w = Integer.parseInt(str[1]);
        int n = Integer.parseInt(br.readLine());

        int board[][] = new int[h][w];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int  l = Integer.parseInt(st.nextToken());
            int  d = Integer.parseInt(st.nextToken());
            int  x = Integer.parseInt(st.nextToken())-1;
            int  y = Integer.parseInt(st.nextToken())-1;

            if(d==0){
                for(int j=y;j<y+l;j++){
                    board[x][j] = 1;
                }
            }else{
                for(int j = x;j<x+l;j++){
                    board[j][y] = 1;
                }
            }

        }

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                bw.write(board[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

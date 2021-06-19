import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        int[] weight = new int[n];
        int[] rank = new int[n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            height[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++){
                if(height[i]<height[j] && weight[i] <weight[j]){
                    rank[i]++;
                }else if(height[i]>height[j] && weight[i] >weight[j]){
                    rank[j]++;
                }
            }
        }
        for(int i=0;i<n;i++){
            rank[i]++;
            bw.write(String.valueOf(rank[i])+"\n");
        }
        bw.flush();
        bw.close();
    }
}

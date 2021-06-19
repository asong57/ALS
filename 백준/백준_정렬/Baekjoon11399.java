import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time=new int[n];
        for(int i=0;i<n;i++){
            time[i] = Integer.parseInt(st.nextToken());
        }
        time = insertSort(time);
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=time[i]*(n-i);
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
    public static int[] insertSort(int[] time){
        for(int i=0;i<time.length;i++){
            int standard = time[i];
            int index = i-1;
            while(index>=0 && standard < time[index]){
                time[index+1] = time[index];
                index--;
            }
            time[index+1]=standard;
        }
        return time;
    }
}

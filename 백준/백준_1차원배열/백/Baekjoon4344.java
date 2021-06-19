import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon4344 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());
        String[] text =new String[number];
        int students;
        StringTokenizer st;
        int sum=0;
        double average = 0;
        double count = 0;
        double percent=0;
        for(int i=0;i<number;i++){
            text[i] = br.readLine();
            st = new StringTokenizer(text[i]);
            students = Integer.parseInt(st.nextToken());
            int[] scores = new int[students];
            for(int j=0;j<students; j++){
                scores[j] = Integer.parseInt(st.nextToken());
                sum+=scores[j];
            }
            average = sum/students;
            for(int j=0;j<students; j++){
               if(scores[j]>average){
                   ++count;
               }
            }
            percent = count/students*100.0;
            bw.write(String.format("%.3f",percent)+"%"+"\n");
            sum=0;
            count=0;
        }
        bw.flush();
        bw.close();
    }
}

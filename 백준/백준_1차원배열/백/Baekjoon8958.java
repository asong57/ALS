import java.io.*;

public class Baekjoon8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine().trim());
        String[] quiz=new String[number];
        int sum =0;
        int count=0;
        for(int i=0;i<number;i++){
            quiz[i]= br.readLine();
            for(int j = 0;j<quiz[i].length();j++){
                if(quiz[i].charAt(j) == 'O'){
                    ++count;
                    sum+=count;
                }else if(quiz[i].charAt(j) == 'X'){
                    count=0;
                    sum+=count;
                }
            }
            bw.write(String.valueOf(sum)+"\n");
            sum=0;
            count=0;
        }
        bw.flush();
        bw.close();
    }
}

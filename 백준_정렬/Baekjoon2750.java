import java.io.*;

public class Baekjoon2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        int[] input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        input = insertSort(input);
        for(int i =0;i<n;i++){
            bw.write(input[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static int[] insertSort(int[] input){
        for(int i=0;i<input.length;i++){
            int standard=input[i];
            int index=i-1;

            while(index>=0 && standard<input[index]){
                input[index+1] = input[index];
                index--;
            }
            input[index+1]=standard;
        }
        return input;
    }
    }

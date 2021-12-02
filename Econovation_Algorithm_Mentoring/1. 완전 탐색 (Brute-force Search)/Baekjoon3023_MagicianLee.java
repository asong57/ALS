import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3023_MagicianLee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[2*r][2*c];

        // 첫번째 왼쪽 위 세팅
        for(int i=0;i<r;i++){
            String input = br.readLine();
            for(int j=0;j<input.length();j++){
                char ch = input.charAt(j);
                arr[i][j] = ch;
            }
        }

        // 오른쪽 위 세팅
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][2*c-j-1] = arr[i][j];
            }
        }

        // 왼쪽 아래 세팅
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[2*r-i-1][j] = arr[i][j];
            }
        }

        //오른쪽 아래 세팅
        for(int i=r;i<2*r;i++){
            for(int j=0;j<c;j++){
                arr[i][2*c-j-1] = arr[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        int err1 = Integer.parseInt(st.nextToken())-1;
        int err2 = Integer.parseInt(st.nextToken())-1;
        if(arr[err1][err2] == '#'){
            arr[err1][err2] = '.';
        }else{
            arr[err1][err2] = '#';
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<2*r;i++){

            for(int j=0;j<2*c;j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}

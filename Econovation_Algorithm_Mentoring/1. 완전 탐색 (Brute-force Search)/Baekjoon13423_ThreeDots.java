import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon13423_ThreeDots {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int a[] = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

            int cnt = 0;
            Arrays.sort(a);
            for (int i = 0; i < n - 2; i++) {
                int k = i + 2;
                for (int j = i + 1; j < n - 1; j++) {
                    int ba = a[j] - a[i];

                    while (k < n && a[k] - a[j] < ba) {
                        k++;
                    }

                    if (k == n) break;

                    if (a[k] - a[j] == ba) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

//좋은 풀이 (이분탐색 곁들이기)
    static int T,N;
    static int arr[];
    public static void main2(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++)
        {
            N=Integer.parseInt(br.readLine());
            arr=new int[N];
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)
            {
                arr[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int cnt=0;
            for(int i=1;i<N-1;i++)
            {
                int l=0;
                int r=N-1;
                while(l<r)
                {
                    int lDist=arr[i]-arr[l];
                    int rDist=arr[r]-arr[i];
                    if(lDist==rDist)
                    {
                        cnt++;
                        l++;
                    }
                    else if(lDist<rDist)
                        r--;
                    else
                        l++;
                }
            }
            System.out.println(cnt);
        }
    }
}

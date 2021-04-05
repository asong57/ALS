import java.util.HashSet;
import java.util.Set;


public class Programmars42839 {
    int answer = 0;
    Set<Integer> set=new HashSet<>();

    public void check_prime(int num){
        int sqrt_num=(int)Math.sqrt(num);
        boolean flag=true;
        if(num==2)
            flag= true;
        else if(num%2==0||num==1)
            flag= false;
        else{
            for(int i=3;i<=sqrt_num;i+=2){
                if(num%i==0)
                    flag= false;
            }
        }
        if(flag){
            set.add(num);
        }
    }
    public void perm(String[] arr, int depth, int k){
        if(depth==k){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<k;i++){
                sb.append(arr[i]);
            }
            int num=Integer.parseInt(sb.toString());
            if(!set.contains(num)){
                check_prime(num);
            }
        }
        else{
            for(int i=depth;i<arr.length;i++){
                swap(arr,i,depth);
                perm(arr,depth+1,k);
                swap(arr,i,depth);
            }
        }
    }
    public void swap(String[] arr, int i, int j){
        String temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int solution(String numbers) {
        String[] str = numbers.split("");
        for(int i=1;i<=str.length;i++){
            perm(str,0,i);
        }
        int answer=set.size();
        return answer;
    }
}

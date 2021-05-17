import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Phoneketmon {
    public int solution(int[] nums) {
     ArrayList<Integer> list = new ArrayList<>();
     list.add(nums[0]);
     for(int i=1;i<nums.length;i++){
         if(!list.contains(nums[i])){
             list.add(nums[i]);
         }
     }
     return list.size() < nums.length/2 ? list.size() :  nums.length/2;
    }
    public int solution2(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num :nums){
            hs.add(num);
        }
        if(hs.size() == nums.length/2){
            return nums.length/2;
        }else{
            return hs.size();
        }
    }
}

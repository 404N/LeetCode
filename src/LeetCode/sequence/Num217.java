package LeetCode.sequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Num217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>(nums.length);
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(map.containsKey(nums[i])){
                return true;
            }else{
                map.put(nums[i],1);
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int x : nums){
            if(set.contains(x)){
                return true;
            }else{
                set.add(x);
            }
//            //官方写法
//            if (!set.add(x)) {
//                return true;
//            }
        }
        return false;
    }
}

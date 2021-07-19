package LeetCode.sequence;

import java.util.*;

public class Num229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        int cnt=nums.length/3;
        if(cnt==0){
            for(int num:nums){
                if(!map.containsKey(num)){
                    res.add(num);
                }
                map.put(num,1);
            }
            return res;
        }
        for(int num:nums){
            if(map.containsKey(num)&&map.get(num)<=cnt){
                int count=map.get(num)+1;
                if(count>cnt){
                    res.add(num);
                    if(res.size()>=2){
                        break;
                    }
                }
                map.put(num,count);
            }else if(!map.containsKey(num)){
                map.put(num,1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Num229 num229=new Num229();
        int[] a={8,8,8,8};
        System.out.println(num229.majorityElement(a));
    }
}

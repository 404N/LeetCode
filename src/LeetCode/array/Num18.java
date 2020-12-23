package LeetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num18 {
    static public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;++i){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int t=target-nums[i];
            for(int j=i+1;j<n;++j){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int z=n-1;
                for(int k=j+1;k<n;++k){
                    if(k>j+1&&nums[k]==nums[k-1]){
                        continue;
                    }
                    while(z>k&&nums[j]+nums[k]+nums[z]>t){
                        z--;
                    }
                    if(z==k){
                        break;
                    }
                    List<Integer> list=new ArrayList<>();
                    if(nums[i]+nums[j]+nums[k]+nums[z]==target){
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[z]);
                        listList.add(list);
                    }
                }

            }
        }
        return listList;
    }

    public static void main(String[] args) {
        int[] nums= {-3,-2,-1,0,0,0,0,1,2,3};
        System.out.println(fourSum(nums,0));
    }
}

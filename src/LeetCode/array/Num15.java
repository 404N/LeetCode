package LeetCode.array;

import java.util.*;

public class Num15 {
    static public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        int n = nums.length;
        if (n <= 2) {
            return listList;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        if(nums[0]>0||nums[n-1]<0){
            return listList;
        }
        for (int i = 0; i < n; ++i) {
            map.put(nums[i], i);
        }
        for(int i=0;i<n;++i){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>0){
                break;
            }
            for(int j=i+1;j<n;++j){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                if(nums[i]+nums[j]>0){
                    break;
                }
                int key=-(nums[i]+nums[j]);
                List<Integer> list=new ArrayList<>();
                Integer z=map.get(key);
                if(z!=null&&key>=nums[j]&&z!=j&&z!=i){
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(key);
                    listList.add(list);
                }
            }
        }
        return listList;
    }

    static public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        if(nums[n-1]<0){
            return listList;
        }
        for(int i=0;i<n;++i){
            if(nums[i]>0){
                break;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int target=-nums[i];
            int z=n-1;
            for(int j=i+1;j<n;++j){
                if(nums[i]+nums[j]>0){
                    break;
                }
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                while(z>j&&nums[z]+nums[j]>target){
                    z--;
                }
                if(j==z){
                    break;
                }
                List<Integer> list=new ArrayList<>();
                if(nums[z]+nums[j]==target){
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[z]);
                    listList.add(list);
                }

            }
        }
        return listList;
    }

    public static void main(String[] args) {
        int[] nums= {0,0};
        System.out.println(threeSum2(nums));
    }
}

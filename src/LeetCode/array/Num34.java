package LeetCode.array;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Num34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[2];
        int start=0,end=nums.length-1;
        int idx=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]>target){
                end=mid-1;
            }
            if(nums[mid]<target){
                start=mid+1;
            }
            if(target==nums[mid]){
                idx=mid;
                break;
            }
        }
        if(idx==-1){
            result[0]=-1;
            result[1]=-1;
        }else{
            int s=idx;
            while(s>=0&&nums[s]==target){
                s--;
            }
            result[0]=s+1;
            while(idx<nums.length&&nums[idx]==target){
                idx++;
            }
            result[1]=idx-1;
        }
        return result;
    }

    public static void main(String[] args) {
        //对Num34的searchRange进行测试
        Num34 num34=new Num34();
        int[] nums={1};
        int target=1;
        int[] result=num34.searchRange(nums,target);
        System.out.println(result[0]+" "+result[1]);
    }
}

package LeetCode.array;


/**
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class Num31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        // 从后往前找到第一个非降序的数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 如果找到了，就从后往前找到第一个比nums[i]大的数
        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 交换两个数
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        // 反转i后面的数
        int left=i+1,right=n-1;
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        //对Num31的nextPermutation进行测试
        Num31 num31=new Num31();
        int[] nums=new int[]{1,2,3};
        num31.nextPermutation(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
}

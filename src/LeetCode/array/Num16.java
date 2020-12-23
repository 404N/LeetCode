package LeetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num16 {
    static public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int min = Math.abs(target - (nums[0] + nums[1] + nums[2]));
        for (int i = 0; i < n; ++i) {
            int z = n - 1;
            for (int j = i + 1; j < n; ++j) {
                while (z > j && nums[i] + nums[z] + nums[j] > target) {
                    z--;
                }
                if (z + 1 < n && Math.abs(target - (nums[i] + nums[j] + nums[z + 1])) < min) {
                    min = Math.abs(target - (nums[i] + nums[j] + nums[z+1]));
                    sum = nums[i] + nums[j] + nums[z + 1];
                }
                if (z!=j&&Math.abs(target - (nums[i] + nums[j] + nums[z])) < min) {
                    min = Math.abs(target - (nums[i] + nums[j] + nums[z]));
                    sum = nums[i] + nums[j] + nums[z];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-100,-98,-2,-1};
        System.out.println(threeSumClosest(nums, -101));
    }
}

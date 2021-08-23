package LeetCode.dp;

public class Num53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        int max = nums[0];
        int count = max;
        for (int i = 1; i < len; i++) {
            if (max < 0 && nums[i] > max) {
                max = nums[i];
            }
            if (count < 0) {
                count = 0;
            }
            if (count + nums[i] > 0) {
                count += nums[i];
                if (max < count) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }

    //动态规划
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for (int x : nums) {
            pre= Math.max((pre + x), x);
            max= Math.max(pre, max);
        }
        return max;
    }
}

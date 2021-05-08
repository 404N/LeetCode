package LeetCode.array;

public class Num26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int len = 0;
        if (n <= 0) {
            return len;
        }
        int temp = nums[0];
        len = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == temp) {
                continue;
            } else {
                temp = nums[i];
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
}

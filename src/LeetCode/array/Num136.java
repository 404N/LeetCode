package LeetCode.array;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class Num136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            // 异或运算
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,2,4,3,3,5,6,7,5,6,7};
        Num136 n = new Num136();
        System.out.println(n.singleNumber(nums));
    }
}

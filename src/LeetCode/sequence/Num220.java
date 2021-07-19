package LeetCode.sequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num220 {

    /**
     * 桶排序
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap<>(nums.length);
        int len = nums.length;
        long w = (long) t + 1;
        for (int i = 0; i < len; i++) {
            long id = getId(nums[i], w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            map.put(id, (long) nums[i]);
            if (i >= k) {
                map.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }


    /**
     * 分桶
     * @param x
     * @param w
     * @return
     */
    private long getId(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }

    public static void main(String[] args) {
        Num220 num220 = new Num220();
        int[] a = {1,5,9,1,5,9};
        System.out.println(num220.containsNearbyAlmostDuplicate(a, 2, 3));
    }
}

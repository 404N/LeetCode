package LeetCode.sequence;

import java.util.HashMap;
import java.util.Map;

public class Num169 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                Integer val = map.get(nums[i]);
                if (val + 1 > len / 2) {
                    return nums[i];
                }
                map.put(nums[i], val + 1);
            }
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        int count = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                temp = nums[i];
            }
            if (nums[i] == temp) {
                count++;
            } else {
                count--;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Num169 num169 = new Num169();
        int[] a = {3, 2, 3};
        System.out.println(num169.majorityElement(a));
    }
}

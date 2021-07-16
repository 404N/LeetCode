package LeetCode.sequence;

import java.util.Collection;
import java.util.Collections;

public class Num179 {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (!isLarge(nums[j], nums[j + 1])) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        if(nums[0]==0){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (Integer num : nums) {
            res.append(num.toString());
        }
        return res.toString();
    }

    private boolean isLarge(Integer a, Integer b) {
        String x = a.toString();
        String y = b.toString();
        return (x + y).compareTo((y + x)) > 0;
    }


    public static void main(String[] args) {
        Num179 num179 = new Num179();
        int[] a = {0,0,0};
        System.out.println(num179.largestNumber(a));
    }
}

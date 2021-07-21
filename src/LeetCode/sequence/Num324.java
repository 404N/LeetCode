package LeetCode.sequence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Num324 {
    public void wiggleSort(int[] nums) {
        int[] a = new int[5001];
        for (int num : nums) {
            a[num]++;
        }
        int end = 5000;
        for (int i = 1; i < nums.length; i += 2) {
            while (a[end] <= 0) {
                end--;
            }
            a[end]--;
            nums[i] = end;
        }
        for (int i = 0; i < nums.length; i += 2) {
            while (a[end] <= 0) {
                end--;
            }
            a[end]--;
            nums[i] = end;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,5,1,1,6,4};
        Num324 num324 = new Num324();
        num324.wiggleSort(a);
        for (int x : a) {
            System.out.println(x);
        }
    }
}

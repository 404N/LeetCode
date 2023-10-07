package LeetCode.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class Num35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                start = mid + 1;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            }
        }
        if (start == end) {
            if (target > nums[start]) {
                return start + 1;
            } else {
                return start;
            }
        } else {
            if (target > nums[start]) {
                return start + 1;
            } else if (end >= 0 && target > nums[end]) {
                return end + 1;
            } else {
                if (end >= 0) {
                    return end;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Num35 num35 = new Num35();
        int[] list = new int[5];
        list[0] = 3;
        list[1] = 5;
        list[2] = 7;
        list[3] = 9;
        list[4] = 10;
        System.out.println(num35.searchInsert(list, 8));
    }
}

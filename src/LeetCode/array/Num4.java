package LeetCode.array;

import java.util.Arrays;

public class Num4 {
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p = nums1.length;
        int q = nums2.length;
        if (p == 0) {
            if (q % 2 == 0) {
                return (nums2[q / 2] + nums2[q / 2 - 1]) / 2.0;
            } else {
                return nums2[q / 2];
            }
        } else if (q == 0) {
            if (p % 2 == 0) {
                return (nums1[p / 2] + nums1[p / 2 - 1]) / 2.0;
            } else {
                return nums1[p / 2];
            }
        }
        int n = p + q;
        int x = -1, y = -1;
        int count = 0;
        while (true) {
            if (x + 1 >= nums1.length) {
                y++;
            } else if (y + 1 >= nums2.length) {
                x++;
            } else if (nums1[x + 1] > nums2[y + 1]) {
                if (y + 1 < nums2.length) {
                    y++;
                } else {
                    x++;
                }
            } else {
                if (x + 1 < nums1.length) {
                    x++;
                } else {
                    y++;

                }
            }
            count++;
            if (count >= n / 2) {
                break;
            }
        }
        System.out.println(x);
        System.out.println(y);
        if (n % 2 == 1) {
            if (x + 1 >= nums1.length) {
                return nums2[y + 1];
            } else if (y + 1 >= nums2.length) {
                return nums1[x + 1];
            } else {
                if (nums1[x + 1] < nums2[y + 1]) {
                    return nums1[x + 1];
                } else {
                    return nums2[y + 1];
                }
            }
        } else {
            int left;
            if (x == -1) {
                left = Math.min(nums1[0], nums2[y]);
            } else if (y == -1) {
                left = Math.min(nums1[x], nums2[0]);
            } else {
                left = Math.max(nums1[x], nums2[y]);
            }
            int right;
            if (x + 1 >= nums1.length) {
                right = nums2[y + 1];
            } else if (y + 1 >= nums2.length) {
                right = nums1[x + 1];
            } else {
                right = Math.min(nums1[x + 1], nums2[y + 1]);
            }
            double res = (left + right) / 2.0;
            return res;
        }
    }

    static public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int [] num;
        num = Arrays.copyOf(nums1, n);
        for(int i=nums1.length;i<num.length;i++){
            num[i]=nums2[i-nums1.length];
        }
        Arrays.sort(num);
        if (n % 2 == 1) {
            return num[n / 2];
        } else {
            double res = (num[n / 2] + num[(n / 2) - 1]) / 2.0;
            return res;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3};
        System.out.println(findMedianSortedArrays1(a, b));
    }
}

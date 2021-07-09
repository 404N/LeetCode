package LeetCode.sequence;

import java.util.Arrays;

public class Num88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cnt=m+n-1;
        while(m-1>=0||n-1>=0){
            if(m-1<0){
                nums1[cnt]=nums2[n-1];
                n--;
            }else if (n-1<0){
                nums1[cnt]=nums1[m-1];
                m--;
            }
            else if(nums1[m-1]>nums2[n-1]){
                nums1[cnt]=nums1[m-1];
                m--;
            }else{
                nums1[cnt]=nums2[n-1];
                n--;
            }
            cnt--;
        }
    }

    public static void main(String[] args) {
        int[] a=new int[1];
        int[] b={1};
        Num88 num88=new Num88();
        num88.merge(a,0,b,1);
        System.out.println(Arrays.toString(a));
    }
}

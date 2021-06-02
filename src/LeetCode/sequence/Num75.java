package LeetCode.sequence;

import java.util.Arrays;
import java.util.Comparator;

public class Num75 {
    public void sortColors(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len-1;i++){
            boolean flag=true;
            for(int j=0;j<len-i-1;j++){
                if(nums[j]>nums[j+1]){
                    flag=false;
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
            if(flag){
                break;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int len=nums.length;
        int start=0;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                nums[i]=nums[start];
                nums[start]=0;
                start++;
            }
        }
        for(int i=0;i<len;i++){
            if(nums[i]==1){
                nums[i]=nums[start];
                nums[start]=1;
                start++;
            }
        }
    }

    public static void main(String[] args) {
        Num75 num75=new Num75();
        int[] a={2,0,2,1,1,0};
        num75.sortColors(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}

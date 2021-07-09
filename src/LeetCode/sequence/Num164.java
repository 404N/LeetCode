package LeetCode.sequence;

import java.util.Arrays;

public class Num164 {
    public int maximumGap(int[] nums) {
        int len=nums.length;
        if(len<2){
            return 0;
        }
        int n=1;
        int m=1;
        int[][] temp=new int[10][len];
        int[] order=new int[10];
        while(m<=10){
            for(int i=0;i<len;i++){
                int num=(nums[i]/n)%10;
                temp[num][order[num]]=nums[i];
                order[num]++;
            }
            boolean flag=true;
            int k=0;
            for(int i=0;i<10;i++){
                if(order[i]!=0){
                    flag=false;
                    for(int j=0;j<order[i];j++){
                        nums[k]=temp[i][j];
                        k++;
                    }
                }
                order[i]=0;
            }
            if(flag){
                break;
            }
            n*=10;
            m++;
        }

        int max=nums[1]-nums[0];
        for(int i=1;i<len-1;i++){
            int d=nums[i+1]-nums[i];
            if(max<d){
                max=d;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Num164 num164=new Num164();
        int[] a={3,6,9,1};
        System.out.println(num164.maximumGap(a));
    }
}

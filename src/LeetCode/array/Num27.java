package LeetCode.array;

public class Num27 {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int mark=0;
        if(n<=0){
            return mark;
        }
        for(int i=0;i<n;++i){
            if(nums[i]!=val){
                if(mark!=i){
                    nums[mark]=nums[i];
                }
                mark++;
            }
        }
        return mark;
    }
}

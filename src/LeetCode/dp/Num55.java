package LeetCode.dp;

public class Num55 {
    public boolean canJump(int[] nums) {
        int len=nums.length;
        int maxIndex=0;
        for(int i=0;i<len;i++){
            if(maxIndex>=i){
                if(maxIndex<(i+nums[i])){
                    maxIndex=i+nums[i];
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Num55 num55=new Num55();
        int[] a={2,3,1,1,4};
        System.out.println(num55.canJump(a));
    }
}

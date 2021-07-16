package LeetCode.sequence;

public class Num215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,k,0,nums.length);
    }

    /**
     * 快速排序
     * @param nums
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int quickSort(int[] nums, int k,int start,int end) {

        return k;
    }

    /**
     * 冒泡排序
     * @param nums
     * @param k
     * @return
     */
    private int bubble(int[] nums, int k) {
        int len=nums.length;
        for (int i=0;i<k;i++){
            boolean flag=true;
            for(int j=0;j<len-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
        }
        for(int num : nums){
            System.out.println(num);
        }
        return nums[len-k];
    }

    //快速排序
    

    public static void main(String[] args) {
        Num215 num215=new Num215();
        int[] a={3,2,3,1,2,4,5,5,6};
        System.out.println(num215.findKthLargest(a,4));
    }
}

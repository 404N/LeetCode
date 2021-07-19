package LeetCode.sequence;

public class Num215 {
    public int findKthLargest(int[] nums, int k) {
        nums=quickSort(nums,k,0,nums.length-1);
        return nums[k-1];
    }

    /**
     * 快速排序
     *
     * @param nums
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int[] quickSort(int[] nums, int k, int start, int end) {
        int key = nums[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (nums[j] < key && j > i) {
                j--;
            }
            while (nums[i] > key && i < j) {
                i++;
            }
            if(nums[i]==nums[j]&&i<j){
                i++;
            }else{
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if(i==j&&j==k-1){
            return nums;
        }
        if(i-1>start){
            nums=quickSort(nums,k,start,i-1);
        }
        if(j+1<end){
            nums=quickSort(nums,k,j+1,end);
        }
        return nums;
    }

    /**
     * 冒泡排序
     *
     * @param nums
     * @param k
     * @return
     */
    private int bubble(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            boolean flag = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
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
        return nums[len - k];
    }


    public static void main(String[] args) {
        Num215 num215 = new Num215();
        int[] a = {3,2,1,5,6,4};
        System.out.println(num215.findKthLargest(a, 2));
    }
}

package LeetCode.dp;

public class Num122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<=1){
            return 0;
        }
        int lastMinValue = prices[0];
        //0表示上升状态，1表示下降
        int count = 0;
        for (int i=1;i<len;i++) {
            if (prices[i] >= lastMinValue) {
                count += (prices[i] - lastMinValue);
            }
            lastMinValue=prices[i];
        }
        return count;
    }

    public static void main(String[] args) {
        Num122 num122=new Num122();
        int[] a={7,1,5,3,6,4};
        System.out.println(num122.maxProfit(a));
    }
}

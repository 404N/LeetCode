package LeetCode.dp;

public class Num121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int min = prices[0];
        int profit = 0;
        for (int i=1;i<len;i++) {
            if(min>prices[i]){
                min=prices[i];
            }else{
                int p=prices[i]-min;
                if(profit<p){
                    profit=p;
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Num121 num121=new Num121();
        int[] a={1,2,3,4,5,0,1,2,3};
        System.out.println(num121.maxProfit(a));
    }
}

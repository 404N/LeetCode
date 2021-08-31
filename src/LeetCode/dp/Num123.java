package LeetCode.dp;

public class Num123 {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int first=0;
        int second=0;
        int min=prices[0];
        boolean isUp=true;
        for(int i=1;i<len;i++){
            if(prices[i]<prices[i-1]){
                isUp=false;
                min=prices[i];
            }else{
                isUp=true;
            }
        }
        return 0;
    }
}

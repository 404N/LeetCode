package LeetCode.dp;

public class Num70 {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int p=1,q=2;
        for(int i=3;i<=n;i++){
            int temp=p+q;
            p=q;
            q=temp;
        }
        return q;
    }

    public static void main(String[] args) {
        Num70 num70=new Num70();
        System.out.println(num70.climbStairs(4));
    }
}

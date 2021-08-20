package LeetCode.dp;

public class Num45 {
    public int jump(int[] nums) {
        int len=nums.length;
        int[] mark=new int[len];
        for(int i=0;i<len;i++){
            mark[i]=-1;
        }
        mark[0]=0;
        for(int i=0;i<len;i++){
            int value=nums[i];
            for(int j=i+1;j<=i+value&&j<len;j++){
                if(j==len-1){
                    return mark[i]+1;
                }else{
                    if(mark[j]==-1){
                        mark[j]=mark[i]+1;
                    }else if((mark[i]+1)<mark[j]){
                        mark[j]=mark[i]+1;
                    }
                }
            }
        }
        return mark[len-1];
    }

    public static void main(String[] args) {
        Num45 num45=new Num45();
        int[] a={1,2,1,1,1};
        System.out.println(num45.jump(a));
    }

    ///nums = [1,2,1,1,1]
    ///mark = [0,1,2,2,2]
}

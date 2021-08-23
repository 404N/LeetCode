package LeetCode.dp;

public class Num64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] mark=new int[m];
        mark[0]=grid[0][0];
        for(int i=1;i<m;i++){
            mark[i]=mark[i-1]+grid[i][0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){
                    mark[j]+=grid[j][i];
                }else{
                    if(mark[j-1]>mark[j]){
                        mark[j]+=grid[j][i];
                    }else{
                        mark[j]=mark[j-1]+grid[j][i];
                    }
                }
            }
        }
        return mark[m-1];
    }

    public static void main(String[] args) {
        Num64 num64=new Num64();
        int[][] a={{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(num64.minPathSum(a));
    }
}

package LeetCode.dp;

public class Num62 {
    public int uniquePaths(int m, int n) {
        int[][] mark=new int[m][n];
        int max=Math.max(m,n);
        for(int i=0;i<max;i++){
            if(i<n){
                mark[0][i]=1;
            }
            if(i<m){
                mark[i][0]=1;
            }

        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                mark[i][j]=mark[i-1][j]+mark[i][j-1];
            }
        }
        return mark[m-1][n-1];
    }

    //优化空间复杂度
    public int uniquePaths1(int m, int n) {
        int[] mark=new int[m];
        for(int i=0;i<m;i++){
            mark[i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                mark[j]+=mark[j-1];
            }
        }
        return mark[m-1];
    }


    public static void main(String[] args) {
        Num62 num62=new Num62();
        System.out.println(num62.uniquePaths1(3,7));
    }
}

package LeetCode.dp;

public class Num63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] mark=new int[m][n];
        mark[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]!=1){
                    int top=0,left=0;
                    if(i-1>=0){
                        top=mark[i-1][j];
                    }if(j-1>=0){
                        left=mark[i][j-1];
                    }
                    if(i==0&&j==0){
                        top=1;
                    }
                    mark[i][j]=top+left;
                }else{
                    mark[i][j]=0;
                }
            }
        }
        return mark[m-1][n-1];
    }

    /**
     * 优化空间复杂度为滚动数组
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[] mark=new int[m];
        mark[0]=1;
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]!=1){
                mark[i]=mark[i-1];
            }else{
                mark[i]=0;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(obstacleGrid[j][i]!=1){
                    if(j>0){
                        mark[j]+=mark[j-1];
                    }
                }else{
                    mark[j]=0;
                }
            }
        }
        return mark[m-1];
    }

    public static void main(String[] args) {
        Num63 num63=new Num63();
        int[][] a={{0,1},{1,0}};
        System.out.println(num63.uniquePathsWithObstacles1(a));
    }
}

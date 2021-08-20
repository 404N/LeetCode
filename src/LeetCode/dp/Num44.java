package LeetCode.dp;

public class Num44 {

    //      *  a  *  b
    //   1  1  0  0  0
    // a 0  1  1  1  0
    // d 0  1  0  1  0
    // c 0  1  0  1  0
    // e 0  1  0  1  0
    // b 0  1  0  1  1

    public boolean isMatch(String s, String p) {
        int lenX=s.length();
        int lenY=p.length();
        boolean[][] mark=new boolean[lenX+1][lenY+1];
        mark[0][0]=true;
        for (int i = 0; i <= lenX; i++) {
            for (int j = 1; j <= lenY; j++) {
                if (p.charAt(j-1) != '*') {
                    if (matches(s, p, i, j)) {
                        mark[i][j] = mark[i-1][j-1];
                    }
                } else {
                    if(j-1>=0&&i-1>=0){
                        mark[i][j]=mark[i][j-1]||mark[i-1][j];
                    }else if(j-1>=0){
                        mark[i][j]=mark[i][j-1];
                    }else{
                        mark[i][j]=mark[i-1][j];
                    }
                }
            }
        }
        for(int i=0;i<=lenX;i++){
            for(int j=0;j<=lenY;j++){
                System.out.print(mark[i][j]+" ");
            }
            System.out.println();
        }
        return mark[lenX][lenY];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '?') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*******b";
        Num44 num44=new Num44();
        System.out.println(num44.isMatch(s,p));
    }
    //      a  c  d  c  b
    // a 0  1  0  0  0  0
    // * 0  1  1  1  1  1
    // c 0  0  1  0  1  0
    // ? 0  0  0  1  0  1
    // b 0  0  0  0  0  0
    // * 0  0  0  0  0  0


    //              mark[i-1][j-1]   s[i]==s[j]||s[j]="?"       p[j]!=*
    //              false            else
    // mark[i][j]=
    //              false            mark[i][j-1]=false         p[j]==*
    //              true             mark[i][j-1]=true
}

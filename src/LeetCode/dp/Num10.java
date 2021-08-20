package LeetCode.dp;

public class Num10 {
    public boolean isMatch(String s, String p) {
        int x = s.length();
        int y = p.length();
        boolean[][] mark = new boolean[x + 1][y + 1];
        mark[0][0] = true;
        for (int i = 0; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (p.charAt(j-1) != '*') {
                    if (matches(s, p, i, j)) {
                        mark[i][j] = mark[i - 1][j - 1];
                    }
                } else {
                    mark[i][j]=mark[i][j-1];
                    if (matches(s, p, i, j-1)) {
                        mark[i][j] = mark[i - 1][j]||mark[i][j];
                    }
                }
            }
        }
        return mark[x][y];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        Num10 num10 = new Num10();
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(num10.isMatch(s, p));
    }
}

package LeetCode.dp;

public class Num5 {
    ///      b  a  b  a  d
    ///   b  1  0  1  0  0
    ///   a  0  1  0  1  0
    ///   b  0  0  1  0  0
    ///   a  0  0  0  1  0
    ///   d  0  0  0  0  1

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        boolean[][] mark = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            mark[i][i] = true;
        }
        int max=1;
        int begin=0;
        char[] chars = s.toCharArray();
        for (int L = 1; L < len; L++) {
            for (int i = 0; i < len; i++) {
                int j = L + i;
                if (j >= len) {
                    break;
                }
                if (chars[i] == chars[j]) {
                    if (j - i < 3) {
                        mark[i][j] = true;
                    } else {
                        mark[i][j] = mark[i + 1][j - 1];
                    }
                } else {
                    mark[i][j] = false;
                }
                if(mark[i][j]&&j-i+1>max){
                    max=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+max);
    }

    public static void main(String[] args) {
        String a = "cbbd";
        Num5 num5=new Num5();
        System.out.println(num5.longestPalindrome(a));
    }


}

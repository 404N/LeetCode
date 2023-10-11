package LeetCode.sequence;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class Num72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 初始化
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        // 动态规划
        for (int i = 1; i <= len1; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char c2 = word2.charAt(j - 1);
                // 如果当前字符相等，那么不需要操作，直接取左上角的值
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果当前字符不相等，那么需要操作，取左上角、左边、上边的最小值+1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    /**
     *        e  x  e  c  u  t  i  o  n
     *     0  1  2  3  4  5  6  7  8  9
     *  i  1  2  2  3  4  5  6  6  7  8
     *  n  2  2  3  3  4  5  6  7  7  7
     *  t  3
     *  e  4
     *  n  5
     *  t  6
     *  i  7
     *  o  8
     *  n  9
     */
    public static void main(String[] args) {
        Num72 num72=new Num72();
        String word1 = "intention", word2 = "execution";
        System.out.println(num72.minDistance(word1,word2));
    }
}


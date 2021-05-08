package LeetCode.tree;

public class Num96 {
    public int numTrees(int n) {
        return dp(n);
    }

    //递归
    public int dp(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += dp(i) * dp(n - i - 1);
        }
        return count;
    }

    //循环
    public int numTrees2(int n) {
        int a[] = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                a[i] += a[j] * a[i - 1 - j];
            }
        }
        return a[n];
    }

    //数学公式
    public int numTrees3(int n) {
        long count = 1;
        for (int i = 0; i < n; i++) {
            count = count * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) count;
    }
}

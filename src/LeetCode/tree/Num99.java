package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Num99 {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Integer i = -1, j = -1;
        TreeNode treeNode = root;
        while (!stack.empty() || treeNode != null) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                treeNode = stack.pop();
                if (list.size() > 0 && treeNode.val < list.get(list.size() - 1)) {
                    j = treeNode.val;
                    if (i == -1) {
                        i = list.get(list.size() - 1);
                    }
                }
                list.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
        dp(root, 2, i, j);
    }

    public void dp(TreeNode treeNode, int count, int x, int y) {
        if (treeNode != null) {
            if (treeNode.val == x || treeNode.val == y) {
                treeNode.val = treeNode.val == x ? y : x;
                count--;
                if(count==0){
                    return;
                }
            }
            dp(treeNode.right, count, x, y);
            dp(treeNode.left, count, x, y);
        }
    }
}

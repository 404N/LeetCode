package LeetCode.tree;

public class Num111 {
    public int minDepth(TreeNode root) {
        return getLevel(root,0);
    }

    public int getLevel(TreeNode node,int level) {
        if (node == null) {
            return level;
        }
        int left = getLevel(node.left,level+1);
        int right = getLevel(node.right,level+1);
        if(left==level+1){
            return right;
        }else if(right==level+1){
            return left;
        }
        return Math.min(left, right);
    }
}

package LeetCode.tree;

public class Num110 {
    public boolean isBalanced(TreeNode root) {
        if(getLevel(root,0)==-2){
            return false;
        }else{
            return true;
        }
    }

    public int getLevel(TreeNode node,int level) {
        if (node == null) {
            return level;
        }
        int left = getLevel(node.left,level+1);
        int right = getLevel(node.right,level+1);
        if(left==-2||right==-2){
            return -2;
        }
        if (left - right > 1 || left - right < -1) {
            return -2;
        }
        return Math.max(left, right);
    }
}

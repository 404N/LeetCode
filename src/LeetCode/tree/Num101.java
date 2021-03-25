package LeetCode.tree;

public class Num101 {

    public boolean isSymmetric(TreeNode root) {
        return dp(root.left,root.right);
    }

    public boolean dp(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return dp(left.right,right.left)&&dp(left.left,right.right);
    }

}

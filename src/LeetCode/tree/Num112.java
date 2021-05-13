package LeetCode.tree;

public class Num112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.val!=targetSum&&root.left==null&&root.right==null){
            return false;
        }
        if(root.val==targetSum&&root.left==null&&root.right==null){
            return true;
        }else{
            return hasPathSum(root.right,targetSum-root.val)||hasPathSum(root.left,targetSum-root.val);
        }
    }
}

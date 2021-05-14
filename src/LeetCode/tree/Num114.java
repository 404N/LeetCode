package LeetCode.tree;

public class Num114 {
    public void flatten(TreeNode root) {
        pre(root);
    }

    public TreeNode pre(TreeNode root){
        if(root!=null){
            TreeNode right=pre(root.left);
            TreeNode rightChild=pre(root.right);
            if(right!=null&&rightChild!=null){
                root.right=right;
                while(right.right!=null){
                    right=right.right;
                }
                right.right=rightChild;
                root.left=null;
            }else if(rightChild==null){
                root.right=right;
                root.left=null;
            }

        }
        return root;
    }
}

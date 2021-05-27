package LeetCode.tree;

/**
 * @author weiqing
 */
public class Num124 {
    int max;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        max=root.val;
        dp(root);
        return max;
    }

    public int dp(TreeNode root){
        if(root.right==null&&root.left==null){
            if(max< root.val){
                max= root.val;
            }
            return root.val;
        }
        int left=0;
        if(root.left!=null){
            left=dp(root.left);
        }
        int right=0;
        if(root.right!=null){
            right=dp(root.right);
        }
        int temp=root.val;
        if(temp+left+right>max){
            max=temp+left+right;
        }
        if(left>0&&left>right){
            temp+=left;
        } else if(right>0&&right>left){
            temp+=right;
        }
        if(max<temp){
            max=temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        TreeNode root1 = new TreeNode(8);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(-9);
        TreeNode root4 = new TreeNode(0);
        TreeNode root5 = new TreeNode(-3);
        TreeNode root6 = new TreeNode(-9);
        TreeNode root7 = new TreeNode(2);
        root.left=root1;
        root.right=root2;
        root1.right=root3;
        root2.left=root4;
        root4.left=root5;
        root5.right=root6;
        root6.right=root7;
        Num124 num124=new Num124();
        System.out.println(num124.maxPathSum(root));
    }
}

/*
                    -1
                8         2
                  -9    0
                      -3
                        -9
                            2
 */
package LeetCode.tree;

public class Num129 {

    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        pre(root,0);
        return sum;
    }

    public void pre(TreeNode root,int val){
        int newVal=val*10+root.val;
        if(root.right==null&&root.left==null){
            sum+=newVal;
        }
        if(root.left!=null){
            pre(root.left,newVal);
        }
        if(root.right!=null){
            pre(root.right,newVal);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(0);
        TreeNode root3 = new TreeNode(5);
        TreeNode root4 = new TreeNode(1);
        root.left=root1;
        root.right=root2;
        root1.left=root3;
        root1.right=root4;
        Num129 num129=new Num129();
        System.out.println(num129.sumNumbers(root));
    }
}

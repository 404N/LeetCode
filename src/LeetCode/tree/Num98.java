package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class Num98 {
    static public boolean isValidBST(TreeNode root) {
        return find(root,null,null);
    }

    //中序遍历
    static public boolean min(TreeNode root, List<Integer> list) {
        boolean left=true;
        boolean right=true;
        if (root != null) {
            left=min(root.left, list);
            if (list.size() != 0 && root.val <= list.get(list.size() - 1)) {
                return false;
            }
            list.add(root.val);
            right=min(root.right, list);
        }
        return left&&right;
    }

    static public boolean min2(TreeNode root, List<Integer> list){
        boolean flag=true;
        boolean left;
        boolean right;
        if(root!=null){
            left=min2(root.left,list);
            if(list.size()==0||root.val>list.get(list.size()-1)){
                list.add(root.val);
            }else{
                return false;
            }
            right=min2(root.right,list);
            flag=left&&right;
        }
        return flag;

    }

    //参考官方解答的设置上下界
    static boolean find(TreeNode treeNode,Integer up,Integer down){
        if(treeNode==null){
            return true;
        }
        if(up!=null&&treeNode.val>=up){
            return false;
        }
        if(down!=null&&treeNode.val<=down){
            return false;
        }
        return find(treeNode.left,treeNode.val,down)&&find(treeNode.right,up,treeNode.val);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(1);

        treeNode.left = treeNode1;
        System.out.println(isValidBST(treeNode));
    }
}

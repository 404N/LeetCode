package LeetCode.tree;

import java.util.*;

public class Num113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> num=new ArrayList<>();
        if(targetSum-root.val==0&&root.left==null&&root.right==null){
            num.add(root.val);
            list.add(num);
            return list;
        }
        if(root.left!=null){
            List<List<Integer>> temp=pathSum(root.left,targetSum-root.val);
            for(int i=0;i<temp.size();i++){
                temp.get(i).add(0,root.val);
            }
            list.addAll(temp);
        }
        if(root.right!=null){
            List<List<Integer>> temp=pathSum(root.right,targetSum-root.val);
            for(int i=0;i<temp.size();i++){
                temp.get(i).add(0,root.val);
            }
            list.addAll(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode root1=new TreeNode(-2);
        TreeNode root2=new TreeNode(-3);
        TreeNode root3=new TreeNode(1);
        TreeNode root4=new TreeNode(3);
        TreeNode root5=new TreeNode(-2);
        TreeNode root6=new TreeNode(-1);
        root.left=root1;
        root.right=root2;
        root1.left=root3;
        root2.left=root4;
        root2.right=root5;
        root3.left=root6;
        Num113 num113=new Num113();
        List<List<Integer>> list=num113.pathSum(root,-1);
        for(List<Integer> num : list){
            System.out.println(num.size());
        }
    }
}

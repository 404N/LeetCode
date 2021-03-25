package LeetCode.tree;

import java.util.*;

public class Num102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new LinkedList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> first=new LinkedList<>();
        first.add(root.val);
        list.add(first);
        while(!queue.isEmpty()){
            List<Integer> num=new LinkedList<>();
            int len=queue.size();
            for(int i=0;i<len;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    num.add(node.left.val);
                    queue.add(node.left);
                }
                if(node.right!=null){
                    num.add(node.right.val);
                    queue.add(node.right);
                }
            }
            if(num.size()>0){
                list.add(num);
            }
        }
        return list;
    }

}

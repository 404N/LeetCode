package LeetCode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new LinkedList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean dir=true;//false为右到左
        while(!queue.isEmpty()){
            List<TreeNode> tempNodes=new LinkedList<>();
            List<Integer> num=new LinkedList<>();
            while(!queue.isEmpty()){
                num.add(queue.peek().val);
                tempNodes.add(queue.poll());
            }
            for(int i=0;i<tempNodes.size();i++){
                TreeNode node;
                if(dir){
                    node=tempNodes.get(tempNodes.size()-1-i);
                    if(node.right!=null){
                        queue.add(node.right);
                    }
                    if(node.left!=null){
                        queue.add(node.left);
                    }
                }else{
                    node=tempNodes.get(tempNodes.size()-1-i);
                    if(node.left!=null){
                        queue.add(node.left);
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                    }
                }
            }
            dir=!dir;
            if(num.size()>0){
                list.add(num);
            }
        }
        return list;
    }
}

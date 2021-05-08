package LeetCode.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）</p>
 *
 * <p>例如：<br />
 * 给定二叉树 <code>[3,9,20,null,null,15,7]</code>,</p>
 *
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 *
 * <p>返回其自底向上的层序遍历为：</p>
 *
 * <pre>
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * </pre>
 * <div><div>Related Topics</div><div><li>树</li><li>广度优先搜索</li></div></div>\n<div><li>👍 432</li><li>👎 0</li></div>
 */

public class Num107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(list);
        return list;
    }
}

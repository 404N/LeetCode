package LeetCode.stack;

import LeetCode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Num173 {
    Queue<Integer> queue = new LinkedList<>();

    //非递归实现
//    public Num173(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode temp = stack.peek();
//            while (temp != null) {
//                temp = temp.left;
//                stack.push(temp);
//            }
//            stack.pop();
//            if (!stack.isEmpty()) {
//                queue.add(stack.peek().val);
//                TreeNode node = stack.peek();
//                stack.pop();
//                stack.push(node.right);
//            }
//        }
//    }

    //递归实现
    public Num173(TreeNode root) {
        find(root);
    }

    public void find(TreeNode root){
        if(root!=null){
            find(root.left);
            queue.add(root.val);
            System.out.println(root.val);
            find(root.right);
        }
    }

    public int next() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }

    public boolean hasNext() {
        return queue.size()>0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(15);
        TreeNode root3 = new TreeNode(9);
        TreeNode root4 = new TreeNode(20);
        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;
        Num173 num173 = new Num173(root);
    }
}

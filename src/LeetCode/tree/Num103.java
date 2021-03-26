package LeetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> first = new LinkedList<>();
        first.add(root.val);
        list.add(first);
        boolean dir = false;
        while (!queue.isEmpty()) {
            List<Integer> num = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (dir) {
                    if (node.left != null) {
                        num.add(node.left.val);
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        num.add(node.right.val);
                        queue.add(node.right);
                    }
                } else {
                    if (node.left != null) {
                        num.add(0, node.left.val);
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        num.add(0, node.right.val);
                        queue.add(node.right);
                    }
                }

            }
            dir = !dir;
            if (num.size() > 0) {
                list.add(num);
            }
        }
        return list;
    }
}

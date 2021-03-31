package LeetCode.tree;

import java.util.HashMap;
import java.util.Map;

public class Num106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return getChild(inorder, postorder, 0, n - 1, 0, n - 1, map);
    }


    public TreeNode getChild(int[] preorder, int[] inorder, int startLeft, int endLeft, int start, int end, Map<Integer, Integer> map) {
        if (startLeft > endLeft) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[startLeft]);
        int target = map.get(preorder[startLeft]);
        int leftSize = target - start;
        node.left = getChild(preorder, inorder, startLeft + 1, startLeft + leftSize, start, target - 1, map);
        node.right = getChild(preorder, inorder, startLeft + leftSize + 1, endLeft, target + 1, end, map);
        return node;
    }

}

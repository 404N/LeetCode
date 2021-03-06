package LeetCode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Num105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = preorder[0];
        int num = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                num = i;
                break;
            }
        }
        if (num - 1 >= 0) {
            node.left = getChild(preorder, inorder, 1, 0, num);
        } else {
            node.left = null;
        }
        if (num + 1 < inorder.length) {
            node.right = getChild(preorder, inorder, 1, num + 1, inorder.length);
        } else {
            node.right = null;
        }
        return node;
    }

    public TreeNode getChild(int[] preorder, int[] inorder, int idx, int start, int end) {
        TreeNode node = new TreeNode();
        int num = -1;
        for (int i = idx; i < preorder.length; i++) {
            for (int j = start; j < end; j++) {
                if (preorder[i] == inorder[j]) {
                    idx = i;
                    node.val = preorder[i];
                    num = j;
                    break;
                }
            }
            if (num != -1) {
                break;
            }
        }
        if (num > -1 && start < num) {
            node.left = getChild(preorder, inorder, idx + 1, start, num);
        } else {
            node.left = null;
        }
        if (num > -1 && num + 1 < end) {
            node.right = getChild(preorder, inorder, idx + 1, num + 1, end);
        } else {
            node.right = null;
        }
        return node;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return getChild2(preorder, inorder, 0, n - 1, 0, n - 1, map);
    }

    public TreeNode getChild2(int[] preorder, int[] inorder, int startLeft, int endLeft, int start, int end, Map<Integer, Integer> map) {
        if (startLeft > endLeft) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[startLeft]);
        int target = map.get(preorder[startLeft]);
        int leftSize = target - start;
        node.left = getChild2(preorder, inorder, startLeft + 1, startLeft + leftSize, start, target - 1, map);
        node.right = getChild2(preorder, inorder, startLeft + leftSize+1, endLeft, target + 1, end, map);
        return node;
    }

    public static void main(String[] args) {
        int a[] = {3, 9, 20, 15, 7};
        int b[] = {9, 3, 15, 20, 7};
        Num105 num105 = new Num105();
        num105.buildTree2(a, b);
    }

}

package LeetCode.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;

        int[] rePostorder=new int[postorder.length];
        int[] reInorder=new int[n];
        for(int i=0;i<n;i++){
            rePostorder[i]=postorder[n-1-i];
            reInorder[i]=inorder[n-1-i];
        }
        for (int i = 0; i < n; i++) {
            map.put(reInorder[i], i);
        }
        return getChild(rePostorder, reInorder, 0, n - 1, 0, n - 1, map);
    }

    public TreeNode getChild(int[] preorder, int[] inorder, int startLeft, int endLeft, int start, int end, Map<Integer, Integer> map) {
        if (startLeft > endLeft||startLeft>=preorder.length||endLeft>=preorder.length) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[startLeft]);
        int target = map.get(preorder[startLeft]);
        int leftSize = target - start;
        node.right = getChild(preorder, inorder, startLeft + 1, startLeft + leftSize, start, target - 1, map);
        node.left = getChild(preorder, inorder, startLeft + leftSize+1, endLeft, target + 1, end, map);
        return node;
    }

    public static void main(String[] args) {
        Num106 num106=new Num106();
        int[] a={9,3,15,20,7};
        int[] b={9,15,7,20,3};
        num106.buildTree(a,b);
    }

}

package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class Num94 {
    static public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        find(root,list);
        return list;
    }

    static public void find(TreeNode root,List<Integer> list){
        if(root!=null){
            find(root.left,list);
            list.add(root.val);
            find(root.right,list);
        }
    }
}

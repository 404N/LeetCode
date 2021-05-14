package LeetCode.tree;

import java.util.ArrayList;
import java.util.List;

public class Num144 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        back(root,list);
        return list;
    }
    void back(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        back(root.left,list);
        back(root.right,list);
        list.add(root.val);
    }
}

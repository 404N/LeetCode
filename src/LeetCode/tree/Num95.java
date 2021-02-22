package LeetCode.tree;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Num95 {
    public List<TreeNode> generateTrees(int n) {
        return dp(1,n);
    }

    //递归
    public List<TreeNode> dp(int start,int end){
        List<TreeNode> list=new LinkedList<>();
        if(start>end){
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left=dp(start,i-1);
            List<TreeNode> right=dp(i+1,end);
            for(int j=0;j<left.size();j++){
                for(int k=0;k<right.size();k++){
                    TreeNode node=new TreeNode(i);
                    node.left=left.get(j);
                    node.right=right.get(k);
                    list.add(node);
                }
            }
        }
        return list;
    }

}

package LeetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Num78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        dfs(nums,0,path,res);
        return res;
    }

    static public void dfs(int[] nums,int depth,List<Integer> path,List<List<Integer>> res){
        if(depth==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[depth]);
        dfs(nums,depth+1,path,res);
        path.remove(path.size()-1);
        dfs(nums,depth+1,path,res);
    }

    public static void main(String[] args) {
        System.out.println(new Num78().subsets(new int[]{1,2,3}));
    }

}

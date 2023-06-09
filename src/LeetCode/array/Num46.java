package LeetCode.array;

import java.util.ArrayList;
import java.util.List;

public class Num46 {
    //返回nums数组的全排列
    static public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        dfs(nums,0,path,used,res);
        return res;
    }

    static public void dfs(int[] nums,int depth,List<Integer> path,boolean[] used,List<List<Integer>> res){
        if(depth==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;++i){
            if(!used[i]){
                path.add(nums[i]);
                used[i]=true;
                dfs(nums,depth+1,path,used,res);
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Num46.permute(new int[]{1,2,3}));
    }
}

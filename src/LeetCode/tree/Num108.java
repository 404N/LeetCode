package LeetCode.tree;

/**
 * <p>给你一个整数数组 <code>nums</code> ，其中元素已经按 <strong>升序</strong> 排列，请你将其转换为一棵 <strong>高度平衡</strong> 二叉搜索树。</p>
 *
 * <p><strong>高度平衡 </strong>二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg" style="width: 302px; height: 222px;" />
 * <pre>
 * <strong>输入：</strong>nums = [-10,-3,0,5,9]
 * <strong>输出：</strong>[0,-3,9,-10,null,5]
 * <strong>解释：</strong>[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree2.jpg" style="width: 302px; height: 222px;" />
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree.jpg" style="width: 342px; height: 142px;" />
 * <pre>
 * <strong>输入：</strong>nums = [1,3]
 * <strong>输出：</strong>[3,1]
 * <strong>解释：</strong>[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * 	<li><code>1 <= nums.length <= 10<sup>4</sup></code></li>
 * 	<li><code>-10<sup>4</sup> <= nums[i] <= 10<sup>4</sup></code></li>
 * 	<li><code>nums</code> 按 <strong>严格递增</strong> 顺序排列</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li></div></div>\n<div><li>👍 760</li><li>👎 0</li></div>
 */
public class Num108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode node=new TreeNode();
        int n=nums.length;
        if(n<=0){
            return null;
        }
        if(n==1){
            node.val=nums[0];
            return node;
        }
        node.val=nums[n/2];
        int[] left=new int[n/2];
        int[] right=new int[n-n/2-1];
        for(int i=0;i<n;i++){
            if(i<n/2){
                left[i]=nums[i];
            }else if(i>n/2){
                right[i-1-n/2]=nums[i];
            }
        }
        node.left=sortedArrayToBST(left);
        node.right=sortedArrayToBST(right);
        return node;
    }

    public static void main(String[] args) {
        int[] nums={-10,-3,0,5,9};
        Num108 num108=new Num108();
        num108.sortedArrayToBST(nums);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return null;
        }
        return establishTreeNode(nums, 0, nums.length-1);
    }
    
    public TreeNode establishTreeNode(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // need to be careful to avoid overflow issue here
        int median = start + (end - start) / 2;
        TreeNode curr = new TreeNode(nums[median]);
        curr.left = establishTreeNode(nums, start, median-1);
        curr.right = establishTreeNode(nums, median+1, end);
        return curr;
    }
}

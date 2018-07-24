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
    private int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxValue;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, helper(root.left));
        int rightSum = Math.max(0, helper(root.right));

        maxValue = Math.max(leftSum + rightSum + root.val, maxValue);
        return Math.max(leftSum, rightSum) + root.val;

    }
}

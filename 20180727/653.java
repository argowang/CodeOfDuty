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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return helper(root, k, new HashSet<Integer>());
    }
    private boolean helper(TreeNode root, int k, HashSet<Integer> expected) {
        if (root == null) {
            return false;
        }

        if (expected.contains(root.val)) {
            return true;
        }
        expected.add(k - root.val);

        return helper(root.left, k, expected) || helper(root.right, k, expected);
    }
}

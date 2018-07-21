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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = p.val < q.val ? p.val : q.val;
        int large = small == p.val ? q.val : p.val;
        return lowestCommonAncestorHelper(root, small, large);

    }
    private TreeNode lowestCommonAncestorHelper(TreeNode root, int small, int large){
        if (root.val < large && root.val > small) {
            return root;
        }
        if (root.val == small || root.val == large){
            return root;
        }
        if (root.val < small) {
            return lowestCommonAncestorHelper(root.right, small, large);
        }
        if (root.val > large) {
            return lowestCommonAncestorHelper(root.left, small, large);
        }
        return null;
    }
}

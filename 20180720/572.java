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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (sameTree(temp, t)) {
                return true;
            } else {
                if (temp.left != null) {
                    stack.push(temp.left);
                }
                if (temp.right != null) {
                    stack.push(temp.right);
                }
            }
        }
        return false;
    }
    
    private boolean sameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return (sameTree(s.left, t.left) && sameTree(s.right, t.right));
    }
}

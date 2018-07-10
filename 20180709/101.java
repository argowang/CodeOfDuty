/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RecursiveSolution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null || helper(root.left, root.right)) {
            return true;
        }
        return false;
    }
    
    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        } else {
            // the val of current nodes should be the same. Then the subtree needs to be symetric as well.
            return left.val == right.val && helper(left.right, right.left) && helper(left.left, right.right);
        }
    }
}

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode left, right;
        if (root.left != null) {
            if (root.right == null) {
                return false;
            }
            stack.push(root.left);
            stack.push(root.right);
        } else if(root.right != null) {
            return false;
        }

        while(!stack.isEmpty()) {
            if (stack.size() % 2 != 0) {
                return false;
            }
            right = stack.pop();
            left = stack.pop();
            if (right.val != left.val) {
                return false;
            }

            if (left.left != null) {
                if (right.right == null) {
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
            } else if(right.right != null) {
                return false;
            }

            if (left.right != null) {
                if (right.left == null) {
                    return false;
                }
                stack.push(left.right);
                stack.push(right.left);
            } else if (right.left != null) {
                return false;
            }
        }

        return true;
    }
}

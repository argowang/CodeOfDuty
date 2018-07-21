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
    private TreeNode firstNode;
    private TreeNode secondNode;
    private TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        traverse(root);
        
        int temp = secondNode.val;
        secondNode.val = firstNode.val;
        firstNode.val = temp;
        return;
    }
    
    // in-order traverse
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // find first misplaced node
        if (firstNode == null && prevNode.val > root.val) {
            firstNode = prevNode;
        }
        // find second misplaced node
        if (firstNode != null && prevNode.val > root.val) {
            secondNode = root;
        }
        prevNode = root;
        traverse(root.right);
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
    public void recoverTree(TreeNode root) {
        // with Moris-traversal
        TreeNode first = null;
        TreeNode second = null;

        TreeNode pred = null; // rightmost node in left tree
        TreeNode prev = null;

        TreeNode curr = root;

        while(curr != null) {
            // find first
            if (prev != null && curr.val <= prev.val) {
                if (first == null) {
                    first = prev;
                }
                second = curr;
            }

            if (curr.left != null) {
                pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                // the left tree has been visited before, remove the connecting edge.
                if (pred.right == curr) {
                    pred.right = null;
                    prev = curr;
                    curr = curr.right;
                } else {
                    pred.right = curr;
                    curr = curr.left;
                }
            } else {
                prev = curr;
                curr = curr.right;
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

}

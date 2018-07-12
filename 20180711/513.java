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
    private int maxHeight = 0;
    private int result;
    public int findBottomLeftValue(TreeNode root) {
        explore(root, 1);
        return result;
    }
    
    public void explore(TreeNode root, int currHeight) {
        if (root.left == null && root.right == null) {
            if (currHeight > maxHeight) {
                maxHeight = currHeight;
                result = root.val;
            }
        }
        
        if (root.left != null) {
            explore(root.left, currHeight + 1);
        }
        
        if (root.right != null) {
            explore(root.right, currHeight + 1);
        }
    }
}

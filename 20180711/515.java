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
    private int maxHeight = -1;
    private List<Integer> result = new ArrayList<Integer>();
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return result;
        }
        explore(root, 0);
        return result;
    }
    
    public void explore(TreeNode root, int level) {
        if (level > maxHeight) {
            maxHeight = level;
            result.add(root.val);
        } else {
            result.set(level, Math.max(result.get(level), root.val));
        }
        if (root.left != null) {
            explore(root.left, level + 1);
        }
        if (root.right != null) {
            explore(root.right, level + 1);
        }
    }
}

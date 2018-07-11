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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        height(root, res);
        return res;
    }
    
    public int height(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return -1;
        }
        int level = 1 + Math.max(height(root.left, res), height(root.right, res));
        if (level + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        return level;
    }
}

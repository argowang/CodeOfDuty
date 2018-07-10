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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root != null) {
            dfs(root, "", result);
        }
        return result;
    }
    
    public void dfs(TreeNode root, String path, List<String> result) {
        String newPath;
        if (path == "") {
            newPath = Integer.toString(root.val);
        } else {
            newPath = path + "->" + root.val;    
        }
        if (root.left == null && root.right == null) {
            result.add(newPath);
        }
        if (root.left != null) {
            dfs(root.left, newPath, result);
        }
        if (root.right != null) {
            dfs(root.right, newPath, result);
        }
    }
}

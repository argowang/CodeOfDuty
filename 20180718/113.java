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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, sum, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(TreeNode root, int remain, List<Integer> currPath, List<List<Integer>> result) {
        if (root.left == null && root.right == null) {
            if (root.val == remain) {
                currPath.add(root.val);
                result.add(new LinkedList(currPath));
                // need to remove the last int
                currPath.remove(currPath.size()-1);
            }
            return;
        }
        currPath.add(root.val);
        if (root.left != null) {
            dfs(root.left, remain-root.val, currPath ,result);
        }
        if (root.right != null) {
            dfs(root.right, remain-root.val, currPath, result);
        }
        currPath.remove(currPath.size()-1);
    }
    
}

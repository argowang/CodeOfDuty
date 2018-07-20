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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreePostin(inorder, 0, inorder.length-1, postorder, 0, inorder.length-1, map);
    }
    
    public TreeNode buildTreePostin(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer,Integer> hm){
        if (is > ie || ps > pe) {
            return null;
        }   
        TreeNode root = new TreeNode(postorder[pe]);
        int rootIndex = hm.get(root.val);
        TreeNode leftchild = buildTreePostin(inorder, is, rootIndex - 1, postorder, ps, ps + rootIndex - is - 1, hm);
        TreeNode rightchild = buildTreePostin(inorder, rootIndex + 1, ie, postorder, ps + rootIndex -is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}

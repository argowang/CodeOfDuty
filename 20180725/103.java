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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.offerFirst(root);
        Boolean isEven = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> current = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                if (isEven) {
                    TreeNode curNode = deque.pollLast();
                    current.add(curNode.val);
                    if (curNode.left != null) {
                        deque.offerFirst(curNode.left);
                    }
                    if (curNode.right != null) {
                        deque.offerFirst(curNode.right);
                    }
                } else {
                    TreeNode curNode = deque.pollFirst();
                    current.add(curNode.val);
                    if(curNode.right != null) {
                        deque.offerLast(curNode.right);
                    }
                    if(curNode.left != null) {
                        deque.offerLast(curNode.left);
                    }
                }
            }
            isEven = !isEven;
            result.add(current);
        }
        return result;
    }
}

package July0713;
import java.util.List;
import java.util.ArrayList;
import java.util.*;


/*
 *  遍历二叉树
 *  中序遍历 recursive 方法
 */
class Solution {
    public List<Integer> list;

    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        if(root==null) return list;
        traversal(root);
        return list;
    }


    // recursive 中序遍历
    public void traversal(TreeNode node) {
        if(node.left!=null) {
            traversal(node.left);
        }
        list.add(node.val);

        if(node.right!=null) {
            traversal(node.right);
        }
    }

    // iteratively 遍历
    // 适用于 binary search tree 的排序
    public Stack<TreeNode> stack;
    public void traversalIteratively(TreeNode node) {
        stack = new Stack<TreeNode>();
        addStackIteratively(node);

        // next node
        while(!stack.empty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(cur.right!=null){
                addStackIteratively(cur.right);
            }
        }
    }

    public void addStackIteratively(TreeNode node) {
        while(node !=null ) {
            stack.push(node);
            node = node.left;
        }
    }




}
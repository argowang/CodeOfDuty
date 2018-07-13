package July0713;//import java.util.LinkedList;
//import java.util.Queue;
import java.util.Stack;
//import July0713.TreeNode;

public class HelloWorld {

    public Stack<TreeNode> stack;

    public HelloWorld(TreeNode root) {
        stack = new Stack<>();
        TreeNode cur = root;
        while(cur !=null) {
            stack.push(cur);
            cur = cur.left;
        }

    }

    public boolean hasNext() {
        return !stack.empty();
    }

    public int next() {
        TreeNode res = stack.pop();
        TreeNode cur = res.right;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return res.val;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");

        TreeNode left1 = new TreeNode(1, null, null);

        TreeNode left2 = new TreeNode(2, left1, null);
        TreeNode right1 = new TreeNode(12,null, null);
        TreeNode root = new TreeNode(10, left2, right1);

        HelloWorld h = new HelloWorld(root);
        System.out.println(h);
        while(h.hasNext()) {
            int res = h.next();
            System.out.println(res);
        }

    }
}

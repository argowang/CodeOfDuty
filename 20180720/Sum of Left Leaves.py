# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.ans = 0
        def dfs(root):
            if not root or (not root.left and not root.right):
                return 0
            else:
                if root.left:
                    if not root.left.left and not root.left.right:
                        self.ans += root.left.val
                    dfs(root.left)
                if root.right:
                    dfs(root.right)
        dfs(root)
        return self.ans
        
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        if not root:
            return []
        cur = []
        res = []
        self.dfs(root, cur, res)
        return res
    
    def dfs(self, root, cur, res):
        cur += [str(root.val)]
        if not root.left and not root.right:
            res += ["->".join(cur)]
        if root.left:
            self.dfs(root.left, cur, res)
        if root.right:
            self.dfs(root.right, cur, res)
        cur.pop()
        
        

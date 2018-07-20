# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findTarget(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: bool
        """
        myset = set()
        def dfs(root):
            if not root:
                return False
            if k - root.val in myset:
                return True
            else:
                myset.add(root.val)
                return dfs(root.right) or dfs(root.left)
        return dfs(root)
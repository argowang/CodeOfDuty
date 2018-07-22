# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []
        res = []
        future = [root]
        while future:
            size = len(future)
            ans = []
            for i in range(size):
                cur = future.pop(0)
                ans.append(cur.val)
                if cur.left:
                    future.append(cur.left)
                if cur.right:
                    future.append(cur.right)
            res.append(ans)
        return res
            
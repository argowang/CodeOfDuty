# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        if not root:
            return []
        future = [root]
        res = []
        while future:
            avg = 0.0
            size = len(future)
            for i in range(size):
                cur = future.pop(0)
                avg += cur.val
                if cur.left:
                    future.append(cur.left)
                if cur.right:
                    future.append(cur.right)
            avg  = avg * 1.0 / size
            res.append(avg)
        return res
        
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        """
        def equal(x, y):
            if not x and not y:
                return True
            elif not x or not y:
                return False
            else:
                return x.val == y.val and equal(x.left, y.left) and equal(x.right, y.right)

        def traverse(s, t):
            return s != None and (equal(s, t) or traverse(s.left, t) or traverse(s.right, t))
        
        return traverse(s,t)

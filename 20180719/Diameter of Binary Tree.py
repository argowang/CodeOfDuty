# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.ans = 1
        def depth(root):
            if root == None:
                return 0
            else:
                L = depth(root.left)
                R = depth(root.right)
                self.ans = max(self.ans, R + L + 1)
                return max(R, L) + 1
        depth(root)
        return self.ans - 1

        


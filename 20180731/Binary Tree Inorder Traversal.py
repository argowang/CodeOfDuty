# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # Recursive method
        # def helper(cur, res):
        #     if not cur:
        #         return 
        #     helper(cur.left, res)
        #     res.append(cur.val)
        #     helper(cur.right, res)
        # res = []
        # helper(root, res)
        # return res
        
        # Stack:
        res = []
        stack = []
        cur = root
        while cur != None or stack:
            while cur != None:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            res.append(cur.val)
            cur = cur.right
        return res
            
        
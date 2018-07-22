# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
#         def max_value(cur):
#             ans = cur
#             while cur:
#                 ans = cur
#                 cur = cur.right
#             return ans.val
        
#         def min_value(cur):
#             ans = cur
#             while cur:
#                 ans = cur
#                 cur = cur.left
#             return ans.val
        
#         def valid(cur):
#             if not cur or (not cur.left and not cur.right):
#                 return True
#             elif not cur.left:
#                 return valid(cur.right) and min_value(cur.right) > cur.val
#             elif not cur.right:
#                 return valid(cur.left) and max_value(cur.left) < cur.val
#             else:
#                 return valid(cur.right) and min_value(cur.right) > cur.val and valid(cur.left) and max_value(cur.left) < cur.val
            
#         return valid(root)
        def validator(node, left_bound, right_bound):
            if not node:
                return True
            if not (left_bound < node.val < right_bound):
                return False
            return validator(node.left, left_bound, node.val) and validator(node.right, node.val, right_bound)
        
        return validator(root, float('-inf'), float('inf'))
        
        
        
        
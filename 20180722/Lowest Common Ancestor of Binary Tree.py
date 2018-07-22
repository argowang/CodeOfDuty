# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findNode(self, root, p):
        """
        Check whether Node "root" is Node "p"'s ancestor
        """
        if not root:
            return False
        elif root.val == p.val:
            return True
        else:
            return self.findNode(root.left, p) or self.findNode(root.right, p)
        
    def lca(self, root, p, q):
        """
        Recuesive method.
        If both, p and q is on the left side, recursive on left;
        ... recursive on right;
        Else if one is on the left and one is on the right:
            Then current node is the common parent.
        """
        p_is_left = self.findNode(root.left, p)
        q_is_left = self.findNode(root.left, q)
        if p_is_left and q_is_left:
            # Find the lowest common ancestor
            return self.lca(root.left, p, q)
        elif not p_is_left and not q_is_left:
            # Find the lowest common ancestor
            return self.lca(root.right, p ,q)
        else:
            return root
        
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        if self.findNode(p,q):
            return p
        elif self.findNode(q, p):
            return q
        else:
            if not root:
                return None
            else:
                return self.lca(root, p, q)

        
            
        
        
                
        
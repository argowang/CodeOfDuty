# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):
 
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.store = []
        self.buildStack(root)
  
    def buildStack(self, cur):
        while cur:
            self.store.append(cur)
            cur = cur.left
           
    def hasNext(self):
        """
        :rtype: bool
        """
        return False if not self.store else True    

    def next(self):
        """
        :rtype: int
        """
        cur = self.store.pop()
        self.buildStack(cur.right)
        return cur.val
        

# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())
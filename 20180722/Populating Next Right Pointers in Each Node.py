# Definition for binary tree with next pointer.
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        if root != None:
            future = [root]
            flag = False
            while future:
                size = len(future)
                for i in range(size):
                    cur = future.pop(0)
                    if i + 1 < size:
                        cur.next = future[0]
                    if cur.left:
                        future.append(cur.left)
                    if cur.right:
                        future.append(cur.right)

                        
            
        
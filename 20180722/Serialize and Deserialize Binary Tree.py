# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return "N"
        res = []
        future = [root]
        while future:
            cur = future.pop(0)
            if cur:
                res.append(str(cur.val))
                future.append(cur.left)
                future.append(cur.right)
            else: 
                res.append("N")
        return ",".join(res)
           
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        vals = data.split(',')
        if vals[0] == 'N':
            return None

        root = TreeNode(int(vals[0]))
        future = [root]
        i = 1
        while future:
            node = future.pop(0)
            if vals[i] != 'N':
                node.left = TreeNode(int(vals[i]))
                future.append(node.left)
            i += 1
            if vals[i] != 'N':
                node.right = TreeNode(int(vals[i]))
                future.append(node.right)
            i += 1
        return root


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
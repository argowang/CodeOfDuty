# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def verticalOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        cols = collections.defaultdict(list)
        future = [(root, 0)]
        while future:
            cur, cur_idx = future.pop(0)
            if cur:
                # Remember only input vale...
                cols[cur_idx].append(cur.val)
                future.append((cur.left, cur_idx - 1))
                future.append((cur.right, cur_idx + 1))
        return [cols[i] for i in sorted(cols)]
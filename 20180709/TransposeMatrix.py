class Solution(object):
    def transpose(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(A) < 1:
            return []
        # for col in range(len(A[0])):
        #     tmp = []
        #     for raw in range(len(A)):
        #         tmp.append(A[raw][col])
        #     res.append(tmp)
        # return res
        expand = [item for row in A for item in row]
        col = len(A[0])
        row = len(A)
        return [[expand[i + (r *col)] for r in range(row)] for i in range(col)]

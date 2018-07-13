class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        res = [[1 for _ in range(level + 1)] for level in range(numRows)]
        for i in range(1, numRows):
            for j in range(1, i):
                res[i][j] = res[i-1][j-1] + res[i-1][j]
        return res
                
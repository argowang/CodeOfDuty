class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        M = len(matrix)
        if M < 1:
            return True
        N = len(matrix[0])
        for i in range(M-1):
            for j in range(N - 1):
                if matrix[i][j] != matrix[i+1][j+1]:
                    return False
        return True

        
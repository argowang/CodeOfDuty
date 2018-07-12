class Solution(object):
    # def add(self, M, i ,j):
    #     sub_M = [[M[r][c] for c in range(j - 1, j + 2, 1)] for r in range( i - 1, i + 2, 1)]
    #     return sum(map(sum, sub_M))
    # def zero_padding(self, M):
    #     new_M = [[0 for _ in range(len(M[0]) + 2)] for _ in range(len(M) + 2)]
    #     for i in range(len(M)):
    #         for j in range(len(M[0])):
    #             new_M[i + 1][j + 1] = M[i][j]
    #     return new_M
    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """
        # new_M = self.zero_padding(M)
        # if (len(M) == 1 or len(M[0]) == 1):
        #     if len(M[0]) == 1 and len(M) == 1:
        #         return M
        #     else:
        #         for i in range(1, len(M) + 1, 1):
        #             for j in range(1, len(M[0]) + 1, 1):
        #                 if (i == 1 or i == len(M)) and (j == 1  or j == len(M[0])):
        #                     M[i - 1][j - 1] = self.add(new_M, i, j) / 2
        #                 else:
        #                     M[i - 1][j - 1] = self.add(new_M, i, j) / 3
        #         return M
        # else:
        #     for i in range(1, len(M) + 1, 1):
        #         for j in range(1, len(M[0]) + 1, 1):
        #             if (i == 1 or i == len(M) or j == 1 or j == len(M[0])):
        #                 if (i == 1 or i == len(M)) and (j == 1 or j == len(M[0])):
        #                     M[i - 1][j - 1] = self.add(new_M, i, j) / 4
        #                 else:
        #                     M[i - 1][j - 1] = self.add(new_M, i, j) / 6
        #             else:
        #                 M[i - 1][j - 1] = self.add(new_M, i, j) / 9
        # return M
        m = len(M)
        n = len(M[0])
        res = [[i for i in row] for row in M]
        for i in range(m):
            for j in range(n):
                total = M[i][j]
                count = 1
                if i > 0:
                    total += M[i-1][j]
                    count += 1
                if j > 0:
                    total += M[i][j - 1]
                    count += 1
                if i < m - 1:
                    total += M[i+1][j]
                    count += 1
                if j < n - 1:
                    total += M[i][j+1]
                    count += 1
                if i > 0 and j > 0:
                    total += M[i-1][j-1]
                    count += 1
                if i < m - 1 and j < n - 1:
                    total += M[i+1][j+1]
                    count += 1
                if i > 0 and j < n - 1:
                    total += M[i-1][j+1]
                    count += 1
                if i < m - 1 and j > 0:
                    total += M[i+1][j-1]
                    count += 1
                res[i][j] = total / count
        return res
        
        
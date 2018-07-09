class Solution(object):
    def invert(self, x):
        return 0 if x == 1 else 1
    def exchange(self, a, b):
        return b,a
    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(A) < 1:
            return []
        for row in A:
            for i in range(len(row)/2):
                row[i] = self.invert(row[i])
                row[len(row) - 1 - i] = self.invert(row[len(row) - 1 - i])
                row[i], row[len(row) - 1 - i] = self.exchange(row[i], row[len(row) - 1 - i])
            if (len(row)%2 != 0):
                row[len(row)/2] = self.invert(row[len(row)/2])
        return A

# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        def BinarySearch(i,j):
            if i >= j:
                return i
            mid = (i + j) / 2
            if isBadVersion(mid) == True:
                return BinarySearch(i, mid)
            else:
                return BinarySearch(mid + 1, j)
        return BinarySearch(1, n)

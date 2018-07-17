class Solution(object):
    def getModifiedArray(self, length, updates):
        """
        :type length: int
        :type updates: List[List[int]]
        :rtype: List[int]
        """
        res = [0 for _ in range(length)]
        for (sta, end, update) in updates:
            res[sta] += update
            if end + 1 < length:
                res[end + 1] -= update
        for i in xrange(1, length):
            res[i] += res[i - 1]
        return res
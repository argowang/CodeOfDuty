class Solution(object):
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        min1 = min2 = float('inf')
        max1 = max2 = float('-inf')
        for i in range(len(arrays)):
            if arrays[i][-1] > max1:
                max2 = max1
                max1 = arrays[i][-1]
                max_idx = i
            elif arrays[i][-1] > max2:
                max2 = arrays[i][-1]
            if arrays[i][0] < min1:
                min2 = min1
                min1 = arrays[i][0]
                min_idx = i
            elif arrays[i][0] < min2:
                min2 = arrays[i][0]
        if max_idx != min_idx:
            return abs(max1 - min1)
        else:
            return max(abs(max1 - min2), abs(max2 - min1))


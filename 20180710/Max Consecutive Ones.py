class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result = 0
        count = 0
        for i in nums:
            if i:
                count += 1
            else:
                result = max(result, count)
                count = 0
        result = max(result, count)
        return result  
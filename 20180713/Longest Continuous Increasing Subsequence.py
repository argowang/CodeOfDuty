class Solution(object):
    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = 0
        idx = 0
        for i in range(1, len(nums)):
            if nums[i] <= nums[i-1]:
                res = max(res, i - idx)
                idx = i
        return max(res, len(nums) - idx)
        
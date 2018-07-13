class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        idx = 0
        while idx < len(nums):
            i = 0
            while i < len(nums) and (i == idx or nums[idx] >= 2 * nums[i]):
                i += 1
            if i == len(nums):
                return idx
            idx += 1
        return -1
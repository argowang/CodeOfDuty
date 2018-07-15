class Solution(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i = 0
        j = len(nums) - 1
        while i < len(nums) - 1 and nums[i] <= nums[i+1]:
            i += 1
        while j > 0 and nums[j] >= nums[j-1]:
            j -= 1
        if (i == len(nums) - 1 and j == 0):
            return 0
        temp = nums[i:j+1]
        min_temp = min(temp)
        max_temp = max(temp)
        while i >= 1 and nums[i-1] > min_temp:
            i -= 1
        while j <= len(nums) - 2 and nums[j + 1] < max_temp:
            j += 1
        return j - i + 1
        
        

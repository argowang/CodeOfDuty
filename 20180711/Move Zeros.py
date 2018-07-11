class Solution(object):
    def exchange(self, a, b):
        return b,a
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        i = -1
        j = i + 1
        p = len(nums) - 1
        while j <= p:
            if nums[j] != 0:
                i += 1
                nums[i], nums[j] = self.exchange(nums[i], nums[j])
            j += 1
        
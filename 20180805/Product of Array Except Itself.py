class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # O(n) time complexity, O(1) Space
        output = [1 for _ in nums]
        accumulate_p_left = 1
        for i in range(len(nums)):
            output[i] = accumulate_p_left
            accumulate_p_left = accumulate_p_left * nums[i]
        accumulate_p_right = 1
        for j in range(len(nums) - 1, -1, -1):
            output[j] = output[j] * accumulate_p_right
            accumulate_p_right = accumulate_p_right * nums[j]
        return output
        
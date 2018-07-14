class Solution(object):
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sum_nums = sum(nums)
        left_sum = 0
        for i in range(len(nums)):
            if left_sum == sum_nums - left_sum - nums[i]:
                return i
            else: 
                left_sum += nums[i]
        return -1

class Solution(object):
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        if k > len(nums):
            return sum(nums) / len(nums)
        else:
            cur_sum = 0
            for i in range(k):
                cur_sum += nums[i]
            res = cur_sum
            for i in range(1,len(nums) - k + 1):
                cur_sum = cur_sum - nums[i - 1] + nums[i + k - 1]
                res = max(res, cur_sum)
            return res * 1.0 / k

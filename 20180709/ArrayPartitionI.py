class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        nums.sort()
        res = [nums[i] for i in range(n) if i%2 == 0]
        return sum(res)

            
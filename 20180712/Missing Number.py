class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        sum_nums = sum(nums)
        whole_n = len(nums)
        add_whole = (0 + whole_n) * (whole_n + 1) / 2
        return add_whole - sum_nums
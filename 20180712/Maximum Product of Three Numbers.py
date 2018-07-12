class Solution(object):
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # positive = [i for i in nums if i >= 0]
        # negative = [i for i in nums if i < 0]
        # positive.sort()
        # negative.sort()
        # if len(positive) == 0:
        #     return negative[-1] * negative[-2] * negative[-3]
        # if len(positive) >= 3:
        #     if len(negative) < 2:
        #         return positive[-1] * positive[-2] * positive[-3]
        #     else:
        #         return max(positive[-1] * positive[-2] * positive[-3], negative[0] * negative[1] * positive[-1])
        # else:
        #     if len(positive) == 1:
        #         return negative[0] * negative[1] * positive[-1]
        #     else:
        #         return negative[-1] * positive[0] * positive[1]
        nums.sort()
        return max(nums[-1] * nums[-2] * nums[-3], nums[0] * nums[1] * nums[-1])

        
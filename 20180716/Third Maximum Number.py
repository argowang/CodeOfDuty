class Solution(object):
    def thirdMax(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 3:
            return max(nums)
        max1 = max2 = max3 = float('-inf')
        for i in nums:
            if i > max1:
                max3 = max2
                max2 = max1
                max1 = i
            elif i > max2 and i != max1:
                max3 = max2
                max2 = i
            elif i > max3 and i != max2 and i != max1:
                max3 = i
        return max3 if max3 != float('-inf') else max1

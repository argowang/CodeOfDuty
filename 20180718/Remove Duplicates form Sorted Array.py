class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # if len(nums) <= 1:
        #     return len(nums)
        # i = 0
        # j = 1
        # p = len(nums) - 1
        # while j <= p:
        #     if nums[j] != nums[i]:
        #         i += 1
        #         nums[i], nums[j] = nums[j], nums[i]
        #     j += 1
        # return i + 1
        if len(nums) == 0:
            return 0
        cur = 0
        for i in range(len(nums)):
            if nums[i] != nums[cur]:
                cur += 1
                nums[i], nums[cur] = nums[cur], nums[i]
        return cur + 1
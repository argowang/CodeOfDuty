class Solution(object):
    def exchange(self, a, b):
        return b,a
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        i = 0
        j = 1
        p = len(nums) - 1
        while j <= p:
            if nums[j] != nums[i]:
                i += 1
                nums[i], nums[j] = self.exchange(nums[i], nums[j])
            j += 1
        return i + 1
        

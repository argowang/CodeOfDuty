class Solution(object):
    def exchange(self, i, j):
        return j,i
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        i = -1
        j = 0
        p = len(nums) - 1
        while j <= p:
            if nums[j] != val:
                i += 1
                nums[i], nums[j] = self.exchange(nums[i], nums[j])
            j += 1
        return i + 1